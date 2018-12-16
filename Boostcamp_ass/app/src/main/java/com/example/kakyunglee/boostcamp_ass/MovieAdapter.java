package com.example.kakyunglee.boostcamp_ass;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<MovieDTO> movieDTOList;


    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        RatingBar rate;
        TextView year;
        TextView director;
        TextView actor;
        LinearLayout listItem;

        MovieViewHolder(View view){
            super(view);
            image = view.findViewById(R.id.image);
            title = view.findViewById(R.id.title);
            rate = view.findViewById(R.id.rate);
            year = view.findViewById(R.id.year);
            director = view.findViewById(R.id.director);
            actor = view.findViewById(R.id.actor);
            listItem = view.findViewById(R.id.list_item);
        }

    }

    MovieAdapter(List<MovieDTO> movieDTOList){
        this.movieDTOList = movieDTOList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item,viewGroup,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, final int i) {
        Glide.with(movieViewHolder.image.getContext()).load(movieDTOList.get(i).getImage()).into(movieViewHolder.image);
        movieViewHolder.title.setText(Html.fromHtml(movieDTOList.get(i).getTitle()).toString());
        movieViewHolder.rate.setRating((float) (movieDTOList.get(i).getUserRating()/2));
        movieViewHolder.year.setText(movieDTOList.get(i).getPubDate());
        movieViewHolder.director.setText(movieDTOList.get(i).getDirector());
        movieViewHolder.actor.setText(movieDTOList.get(i).getActor());

        movieViewHolder.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, ConnectLink.class);
                intent.putExtra("url",movieDTOList.get(i).getLink());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieDTOList.size();
    }


}
