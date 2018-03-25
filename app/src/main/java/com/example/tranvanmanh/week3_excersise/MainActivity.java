package com.example.tranvanmanh.week3_excersise;

import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.MovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Movie> list;
    String movieData;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        new GetJsonFromWeb().execute(url);
    }
    class GetJsonFromWeb extends AsyncTask<String, String, String>{

        OkHttpClient client = new OkHttpClient();
        @Override
        protected String doInBackground(String... strings) {
            Request request = new Request.Builder().url(strings[0]).build();
            try {
              Response response =   client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!s.equals(""))
            {
                movieData = s;
                //  Log.e("abc", movieData);
                recyclerView = (RecyclerView)findViewById(R.id.rcv_listmovie);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);

                recyclerView.setHasFixedSize(true);
                list = new ArrayList<Movie>();
                Gson gson = new Gson();
                Type listType = new TypeToken<Profile>(){}.getType();
                Profile profiles = gson.fromJson(movieData, listType);
                List<Result> results = profiles.getResults();
                for(int i = 0 ; i < results.size(); i++)
                {

                    list.add(new Movie(results.get(i).getReleaseDate(), results.get(i).getVoteAverage(), results.get(i).getTitle(), results.get(i).getOverview(),"https://image.tmdb.org/t/p/w500" + results.get(i).getPosterPath()));;

                }
                MovieAdapter adapter = new MovieAdapter(MainActivity.this, list);
                recyclerView.setAdapter(adapter);
            }
            else {
                Toast.makeText(MainActivity.this, "toi roi", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
