package com.example.gnewsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gnewsapp.Model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<News> newsList;

    public Adapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.title.setText(news.getTitle());
        holder.author.setText(news.getSource().getName());
        holder.source.setText(news.getSource().getUrl());

        String imgUrl = news.getImage();
        String url = news.getUrl();

        Picasso.with(context).load(imgUrl).into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contentViewIntent = new Intent(context, ContentView.class);
                contentViewIntent.putExtra("title",news.getTitle());
                contentViewIntent.putExtra("author",news.getSource().getName());
                contentViewIntent.putExtra("source",news.getSource().getUrl());
                contentViewIntent.putExtra("description",news.getDescription());
                contentViewIntent.putExtra("publishAt",news.getPublishedAt());
                contentViewIntent.putExtra("imgUrl",news.getImage());
                contentViewIntent.putExtra("url",news.getUrl());
                context.startActivity(contentViewIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,author,source;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.cardTitleView);
            author = itemView.findViewById(R.id.cardAuthorView);
            source = itemView.findViewById(R.id.cardSourceLinkView);
            imageView = itemView.findViewById(R.id.cardImageView);
            cardView = itemView.findViewById(R.id.newsCardView);
        }
    }
}
