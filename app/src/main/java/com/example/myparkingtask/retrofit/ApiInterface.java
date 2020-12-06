package com.example.myparkingtask.retrofit;

import com.example.myparkingtask.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/books/v1/volumes")
    Call<ResponseData> getAll( @Query("q") String search);
}
