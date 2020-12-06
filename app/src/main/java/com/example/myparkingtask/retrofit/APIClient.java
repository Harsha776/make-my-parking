package com.example.myparkingtask.retrofit;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(Context mContext){
        if(retrofit==null){

                OkHttpClient.Builder okHttpClient=new OkHttpClient.Builder()
                        .addInterceptor(new NetworkConnectionInterceptor(mContext));
                retrofit=new Retrofit.Builder()
                        .baseUrl("https://www.googleapis.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient.build())
                        .build();
        }
        return retrofit;
    }

   /* public static Retrofit getClient(Context mContext) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new NetworkConnectionInterceptor(mContext)).build();


        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }*/
}
