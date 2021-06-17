package com.example.gnewsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;;

public class ApiClient {

    private static final String URL = "https://gnews.io/api/v4/";
    private static ApiClient apiClient;
    private static Retrofit retrofit;

    private ApiClient(){
        retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance(){

        if(apiClient == null){
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public InterfaceApi getApiClient(){
        return retrofit.create(InterfaceApi.class);
    }
}
