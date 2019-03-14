package com.route.newsmvpg1;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.route.Adapters.NewsAdapter;
import com.route.Base.BaseActivity;
import com.route.Contracts.NewsContract;
import com.route.Model.NewsResponse.ArticlesItem;

import java.util.List;

public class HomeActivity extends BaseActivity
        implements NewsContract.NewsView {

    NewsContract.NewsPresenter presenter;
    RecyclerView recyclerView;
    NewsAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(activity);
        adapter=new NewsAdapter(null);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        presenter=new NewsPresenter(this);
        presenter.getNews();
    }

    @Override
    public void showLoading() {
        showProgressBar(R.string.loading);
    }

    @Override
    public void hideLoading() {
        hideProgressBar();
    }

    @Override
    public void showMessage(String title, String content) {
        showMessage(title,content,getString(R.string.ok));
    }

    @Override
    public void showData(List<ArticlesItem> newsList) {
        adapter.changeData(newsList);
    }
}
