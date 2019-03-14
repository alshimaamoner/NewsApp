package com.route.newsmvpg1;

import com.route.Contracts.NewsContract;
import com.route.Model.NewsResponse.NewsResponse;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 3/8/2019.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class NewsPresenter implements NewsContract.NewsPresenter {

    NewsContract.NewsModel model;
    NewsContract.NewsView view;

    public NewsPresenter(NewsContract.NewsView view) {
        this.view = view;
        model=new NewsModel(this);
    }

    @Override
    public void getNews() {
        view.showLoading();
        model.getNewsFromApi("en");
    }

    @Override
    public void newsPrepared(NewsResponse newsResponse) {
        view.hideLoading();
        if(newsResponse==null){
            view.showMessage("Error","cannot get news");
        }else {
            view.showData(newsResponse.getArticles());
        }
    }
}
