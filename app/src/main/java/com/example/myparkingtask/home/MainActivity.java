package com.example.myparkingtask.home;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.myparkingtask.R;
import com.example.myparkingtask.databinding.ActivityMainBinding;
import com.example.myparkingtask.model.Items;
import com.example.myparkingtask.utlility.Utility;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainViewPresenter.View {

    ActivityMainBinding activityMainBinding;
    @Inject MainViewPresenter.Presenter presenter;
    RecyclerAdapter recyclerAdapter;
    ArrayList<Items> items=new ArrayList<>();
    private LinearLayoutManager mLinearLayoutManager;
    private NetworkChangeReceiver receiver;
    boolean isLoading = false;
    boolean isSearch=false;
    private boolean isConnected = false;
    Animation a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        intializeView();
    }

    private void intializeView(){
        activityMainBinding.search.addTextChangedListener(textWatcher);
        presenter.getList("f");
        recyclerAdapter = new RecyclerAdapter(items);
        mLinearLayoutManager = new GridLayoutManager(this,
                Utility.isTablet(this) ? 4 : 2, GridLayoutManager.VERTICAL,
                false);
        activityMainBinding.rvAdapter.setLayoutManager(mLinearLayoutManager);
        activityMainBinding.rvAdapter.setAdapter(recyclerAdapter);

        activityMainBinding.rvAdapter.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == items.size() -1) {
                        //bottom of list!
                        presenter.getList("f");
                        isLoading = true;
                    }
                }
            }
        });

        a = AnimationUtils.loadAnimation(this, R.anim.animation);           //giving animation for Network manager text
        a.reset();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver();
        registerReceiver(receiver, filter);
    }

    /**
     * textchange listner for Edittext
     */
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().trim().equals("")) {
                presenter.getList("f");
                isSearch=false;
            }
            else {
                isSearch=true;
                presenter.getList(s.toString());                                      //callimg Ai
            }

        }


    };

    /**
     * visiabling the progressbar
     */
    @Override
    public void showProgess() {
        activityMainBinding.progress.setVisibility(View.VISIBLE);
    }

    /**
     * hiding the progressbar
     */
    @Override
    public void hideProgess() {
        activityMainBinding.progress.setVisibility(View.GONE);
    }

    @Override
    public void setData(ArrayList<Items> items) {
        isLoading=false;
        if(isSearch){
            this.items.clear();
            this.items.addAll(items);
            recyclerAdapter.notifyDataSetChanged();
        }else {
            this.items.addAll(items);
            recyclerAdapter.notifyDataSetChanged();
        }
    }

    /**
     * using the BroadcastReceiver to check internet connection
     */
    public class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, final Intent intent) {
            isNetworkAvailable(context);
        }

        /**
         * checking the internet connection
         * @param context passing acivity
         */
        private void isNetworkAvailable(Context context) {
            ConnectivityManager connectivity = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo[] info = connectivity.getAllNetworkInfo();
                for (NetworkInfo networkInfo : info) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        if (!isConnected) {
                            activityMainBinding.networkStatus.setText(getResources().getString(R.string.not_connected));
                            activityMainBinding.networkStatus.setVisibility(View.GONE);
                            isConnected = true;
                            presenter.getList("f");
                        }
                        return;
                    }
                }
            }
            activityMainBinding.networkStatus.setText(getResources().getString(R.string.not_connected));
            activityMainBinding.networkStatus.setVisibility(View.VISIBLE);
            activityMainBinding.networkStatus.clearAnimation();
            activityMainBinding.networkStatus.startAnimation(a);
            isConnected = false;
        }
    }
}