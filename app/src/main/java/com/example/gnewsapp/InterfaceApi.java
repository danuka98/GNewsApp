package com.example.gnewsapp;

import com.example.gnewsapp.Model.Title;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceApi {

    @GET("top-headlines")
    Call<Title> getTitles (
            @Query("token") String apiToken
    );
}
