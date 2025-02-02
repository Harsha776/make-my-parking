package com.example.myparkingtask.retrofit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.animation.Interpolator;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkConnectionInterceptor implements Interceptor {
    private Context context;

    public NetworkConnectionInterceptor(Context context){
        this.context=context;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        if(!isConnected()){
            throw new NoConnectivityException();
        }
        Request.Builder builder=chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

    public boolean isConnected(){
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        return (info!=null && info.isConnected());
    }
}
