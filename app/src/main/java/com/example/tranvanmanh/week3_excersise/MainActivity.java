package com.example.tranvanmanh.week3_excersise;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.MovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView()
    {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rcv_listmovie);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
         list = new ArrayList<>();
        Gson gson = new Gson();
        Type listType = new TypeToken<Profile>(){}.getType();
       Profile profiles = gson.fromJson(MyApp.msgMovie, listType);
        List<Result> results = profiles.getResults();
        for(int i = 0 ; i < results.size(); i++)
        {

             //  Log.e("abc", results.get(i).getPosterPath());
            list.add(new Movie(results.get(i).getReleaseDate(), results.get(i).getVoteAverage(), results.get(i).getTitle(), results.get(i).getOverview(),"https://image.tmdb.org/t/p/w500" + results.get(i).getPosterPath()));
        }


        MovieAdapter adapter = new MovieAdapter(this, list);

        recyclerView.setAdapter(adapter);

    }
}
