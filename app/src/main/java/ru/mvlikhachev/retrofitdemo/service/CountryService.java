package ru.mvlikhachev.retrofitdemo.service;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.mvlikhachev.retrofitdemo.model.CountryInfo;

public interface CountryService {

    @GET("country/get/all")
    Call<CountryInfo> getResults();
}
