package com.example.movieworld.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movieworld.R;
import com.example.movieworld.service.RetrofitInstance;
import com.example.movieworld.service.MovieDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private ArrayList<Movie> listOfMovies;
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public Repository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){
        MovieDataService movieDataService = RetrofitInstance.getService();
        Call<Result> call = movieDataService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if(result != null && result.getResults() != null){
                    listOfMovies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(listOfMovies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
