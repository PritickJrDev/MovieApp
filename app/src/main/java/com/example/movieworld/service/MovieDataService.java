package com.example.movieworld.service;

import com.example.movieworld.model.Movie;
import com.example.movieworld.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {
    //Base URL : https://api.themoviedb.org/3/
    //End Point URL: movie/popular?api_key=c32a3b25c39ac529e44d4539581c1824
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);

}
