package com.example.gnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ContentView extends AppCompatActivity {

    TextView title,source,author, description, publishAt;
    ImageView imageView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_view);

        title = findViewById(R.id.cardTitleView);
        source = findViewById(R.id.cardSourceLinkView);
        author = findViewById(R.id.cardAuthorView);
        description = findViewById(R.id.description);
        publishAt = findViewById(R.id.publishAt);
        imageView = findViewById(R.id.cardImageView);
        webView = findViewById(R.id.cardWebView);

        Intent getIntent = getIntent();
        String gettitle = getIntent.getStringExtra("title");
        String getauthor = getIntent.getStringExtra("author");
        String getsource = getIntent.getStringExtra("source");
        String getimgUrl = getIntent.getStringExtra("imgUrl");
        String geturl = getIntent.getStringExtra("url");
        String getdescription = getIntent.getStringExtra("description");
        String getpublishAt = getIntent.getStringExtra("publishAt");

        title.setText(gettitle);
        source.setText(getsource);
        author.setText(getauthor);
        description.setText(getdescription);
        publishAt.setText("PublishAt: "+getpublishAt);

        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(geturl);

        Picasso.with(ContentView.this).load(getimgUrl).into(imageView);



    }
}
