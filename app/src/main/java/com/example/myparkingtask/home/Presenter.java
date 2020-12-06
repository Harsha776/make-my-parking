package com.example.myparkingtask.home;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.example.myparkingtask.model.ResponseData;
import com.example.myparkingtask.retrofit.APIClient;
import com.example.myparkingtask.retrofit.ApiInterface;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements MainViewPresenter.Presenter{

    ApiInterface apiInterface;
    Context mContext;
    @Inject MainViewPresenter.View view;
    @Inject
    Activity activity;

    @Inject
    Presenter(){

    }
   /* Presenter(MainViewPresenter.View view){
        this.view=view;
        mContext= (Context) view;
    }*/

    @Override
    public void getList(String search) {
        view.showProgess();
        apiInterface = APIClient.getRetrofitClient((Context) view).create(ApiInterface.class);
        Call<ResponseData> call = apiInterface.getAll(search);

        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(@NotNull Call<ResponseData> call, @NotNull Response<ResponseData> response) {
                view.hideProgess();
                if (response.code() == 200) {
                    ResponseData pojoRes= response.body();
                    if (pojoRes != null) {
                        Log.d("TAG", "reponse body: "+pojoRes.getItems().size());
                        view.setData(pojoRes.getItems());
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseData> call, @NotNull Throwable t) {
                view.hideProgess();
                Log.d("TAG", "onFailure: "+call.toString());
                Log.d("TAG", "onFailure: Throwable "+t.getMessage());
            }
        });
    }

}
