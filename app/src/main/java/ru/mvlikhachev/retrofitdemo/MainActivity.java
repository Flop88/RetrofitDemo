package ru.mvlikhachev.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mvlikhachev.retrofitdemo.model.CountryInfo;
import ru.mvlikhachev.retrofitdemo.model.Result;
import ru.mvlikhachev.retrofitdemo.service.CountryService;
import ru.mvlikhachev.retrofitdemo.service.RetrofitInstance;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> resultArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCounties();
    }

    private Object getCounties() {

        CountryService countryService = RetrofitInstance.getService();

        Call<CountryInfo> call = countryService.getResults();

        call.enqueue(new Callback<CountryInfo>() {
            @Override
            public void onResponse(Call<CountryInfo> call, Response<CountryInfo> response) {

                CountryInfo countryInfo = response.body();
                if (countryInfo != null && countryInfo.getRestResponse() != null) {
                    resultArrayList =
                            (ArrayList<Result>) countryInfo
                                    .getRestResponse()
                                    .getResult();

                    Log.d("resultArrayList", "Countries:");
                    for (Result result : resultArrayList) {
                        Log.d("resultArrayList", result.getName());
                    }
                }

            }

            @Override
            public void onFailure(Call<CountryInfo> call, Throwable t) {
                Log.d("resultArrayList", "FAIL!!!: " + t);
            }
        });
        return resultArrayList;
    }
}