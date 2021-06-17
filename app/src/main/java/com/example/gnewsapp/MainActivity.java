package com.example.gnewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gnewsapp.Model.News;
import com.example.gnewsapp.Model.Title;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<News> newsList = new ArrayList<>();
    Adapter adapter;
    final String Api_Token = "303d95cfec5c50ee20fec1051cd04d50";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        jsonfile(Api_Token);
    }

    public void jsonfile(String apiToken){

        Call<Title> titleCall = ApiClient.getInstance().getApiClient().getTitles(apiToken);
        titleCall.enqueue(new Callback<Title>() {
            @Override
            public void onResponse(Call<Title> call, Response<Title> response) {
                if (response.isSuccessful() && response.body().getNews() != null){
                    newsList.clear();
                    newsList = response.body().getNews();
                    adapter = new Adapter(MainActivity.this,newsList);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<Title> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Msg : " +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
