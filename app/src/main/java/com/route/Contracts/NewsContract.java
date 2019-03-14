package com.route.Contracts;

import com.route.Model.NewsResponse.ArticlesItem;
import com.route.Model.NewsResponse.NewsResponse;

import java.util.List;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 3/8/2019.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class NewsContract {
    public interface NewsModel{
        void getNewsFromApi(String lang);
    }
    public interface NewsView{
         void showLoading();
         void hideLoading();
         void showMessage(String title,String content);
         void showData(List<ArticlesItem> newsList);
    }
    public interface NewsPresenter{
       void getNews();
       void newsPrepared(NewsResponse newsResponse);
    }
}
