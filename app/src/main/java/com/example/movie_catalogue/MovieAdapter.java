package com.example.movie_catalogue;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;
    MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie movie = (Movie)getItem(position);
        viewHolder.bind(movie);
        return convertView;
    }

    private class ViewHolder {
        private ImageView imgPhoto;
        private TextView txtTitle;
        private TextView txtSpoiler;

        ViewHolder(View convertView){
            imgPhoto = convertView.findViewById(R.id.img_photo);
            txtTitle = convertView.findViewById(R.id.txt_title);
            txtSpoiler = convertView.findViewById(R.id.txt_spoiler);
        }

        void bind(Movie movie) {
            imgPhoto.setImageResource(movie.getPhoto());
            txtTitle.setText(movie.getTitle());
            txtSpoiler.setText(movie.getSpoiler());
        }
    }
}
