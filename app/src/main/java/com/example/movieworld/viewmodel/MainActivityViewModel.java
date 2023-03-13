package com.example.movieworld.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieworld.R;
import com.example.movieworld.model.Movie;
import com.example.movieworld.model.Repository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private Repository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<Movie>> getAllMovies(){
        return repository.getMutableLiveData();
    }
}
