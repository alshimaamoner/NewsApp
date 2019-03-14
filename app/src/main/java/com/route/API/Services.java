package com.route.API;


import com.route.Model.NewsResponse.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 2/15/2019.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public interface Services {



    @GET("everything")
    Call<NewsResponse> getNewsBySourceId(@Query("apiKey") String apikey,
                                         @Query("language") String language,
                                         @Query("sources") String sources);
}
