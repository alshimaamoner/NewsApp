package com.route.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.route.Model.NewsResponse.ArticlesItem;
import com.route.newsmvpg1.R;

import java.util.List;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 2/15/2019.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


    List<ArticlesItem> newsList;

    public NewsAdapter(List<ArticlesItem> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view_news,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        ArticlesItem news = newsList.get(pos);
        viewHolder.title.setText(news.getTitle());
        if(news.getSource()!=null)
            viewHolder.sourceName.setText(news.getSource().getName());
        viewHolder.time.setText(news.getPublishedAt());

        Glide.with(viewHolder.itemView)
                .load(news.getUrlToImage())
                .into(viewHolder.image);

    }

    public void changeData(List<ArticlesItem> items){
        this.newsList=items;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (newsList==null)
            return 0;
        return newsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,sourceName,time;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title =itemView.findViewById(R.id.title);
            sourceName =itemView.findViewById(R.id.source_name);
            time =itemView.findViewById(R.id.time);
            image =itemView.findViewById(R.id.image);

        }
    }
}
