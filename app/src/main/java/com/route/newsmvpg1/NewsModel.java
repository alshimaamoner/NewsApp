package com.route.newsmvpg1;

import com.route.API.ApiManager;
import com.route.Contracts.NewsContract;
import com.route.Model.NewsResponse.NewsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 3/8/2019.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class NewsModel implements NewsContract.NewsModel {

    public static final String APIKEY = "b157611e9895467ebfb67ff2c10f9c5b";
    NewsContract.NewsPresenter presenter;

    public NewsModel(NewsContract.NewsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getNewsFromApi(String lang) {
        ApiManager.getAPIs()
                .getNewsBySourceId(APIKEY,lang,"abc-news")
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        presenter.newsPrepared(response.body());
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        presenter.newsPrepared(null);
                    }
                });

    }
}
