package com.example.tranvanmanh.week3_excersise;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tranvanmanh on 3/15/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.activity_list_movie, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(movieArrayList.get(position).getPathpicture()).into(holder.poster);
        holder.title.setText(movieArrayList.get(position).getTille());
        holder.discription.setText(movieArrayList.get(position).getDiscription());
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView poster;
        TextView title, discription;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            poster = (ImageView) itemView.findViewById(R.id.imvposter);
            title = (TextView) itemView.findViewById(R.id.tvtitle);
            discription = (TextView) itemView.findViewById(R.id.tvdiscription);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, MovieDetails.class);
            intent.putExtra("pathposter", movieArrayList.get(position).getPathpicture());
            Log.e("abc", movieArrayList.get(position).getPathpicture());
            intent.putExtra("tile", movieArrayList.get(position).getTille());
            intent.putExtra("releasedate", movieArrayList.get(position).getRealeaseDate());
           intent.putExtra("voteavarage", movieArrayList.get(position).getVoteAvarage());
           intent.putExtra("discription", movieArrayList.get(position).getDiscription());
            context.startActivity(intent);

        }
    }


}
