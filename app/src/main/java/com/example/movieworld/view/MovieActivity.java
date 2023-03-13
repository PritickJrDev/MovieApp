package com.example.movieworld.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.movieworld.R;
import com.example.movieworld.databinding.ActivityMovieBinding;
import com.example.movieworld.model.Movie;

public class MovieActivity extends AppCompatActivity {

    Movie movie;
    ActivityMovieBinding activityMovieBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        activityMovieBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie);

        Intent i = getIntent();
        if(i != null){
            movie = i.getParcelableExtra("movie");
            activityMovieBinding.setMovie(movie);
            getSupportActionBar().setTitle(movie.getTitle());
            Toast.makeText(this, "working, success", Toast.LENGTH_SHORT).show();
            Log.i("TAG","success");
        } else {
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
            Log.i("TAG","failed");

        }

    }
}