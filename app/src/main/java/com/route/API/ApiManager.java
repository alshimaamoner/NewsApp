package com.route.API;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 2/15/2019.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class ApiManager  {

    private static Retrofit retrofitInstance;

    private static Retrofit getInstance(){
        if(retrofitInstance==null){

            HttpLoggingInterceptor httpLoggingInterceptor
                    =new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.e("api",message);
                }
            });
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

            retrofitInstance = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();


        }
        return retrofitInstance;

    }

    public static Services getAPIs(){
      return   getInstance()
                .create(Services.class);
    }



}
