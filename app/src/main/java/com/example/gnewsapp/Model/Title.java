package com.example.gnewsapp.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Title {

    @SerializedName("totalArticles")
    @Expose
    private String totalArticles;

    @SerializedName("articles")
    @Expose
    private List<News> News;

    public String getTotalArticles() {
        return totalArticles;
    }

    public void setTotalArticles(String totalArticles) {
        this.totalArticles = totalArticles;
    }

    public List<News> getNews() {
        return News;
    }

    public void setNews(List<com.example.gnewsapp.Model.News> news) {
        News = news;
    }
}
