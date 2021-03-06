package ru.mvlikhachev.retrofitdemo.service;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Singleton
public class RetrofitInstance {

    private static Retrofit retrofit = null;

    private static String BASE_URL = "http://www.groupkt.com/";

    public static CountryService getService() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CountryService.class);
    }
}
