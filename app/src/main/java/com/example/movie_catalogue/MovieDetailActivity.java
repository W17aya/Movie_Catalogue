package com.example.movie_catalogue;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String KEY_EXTRA = "KEY_EXTRA";
    ImageView imgPhoto;
    TextView txtTitle, txtSpoiler, txtGenre, txtReleased;
    int photo;
    String title, spoiler, genre, released;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        imgPhoto = findViewById(R.id.img_photo);
        txtTitle = findViewById(R.id.txt_title);
        txtSpoiler = findViewById(R.id.txt_spoiler);
        txtGenre = findViewById(R.id.txt_genre);
        txtReleased = findViewById(R.id.txt_released);

        intentData();
    }
    private void intentData(){
        Movie movies = getIntent().getParcelableExtra(KEY_EXTRA);
        photo = movies.getPhoto();
        title = movies.getTitle();
        spoiler = movies.getSpoiler();
        genre = movies.getGenre();
        released = movies.getReleased();

        imgPhoto.setImageResource(photo);
        txtTitle.setText(title);
        txtSpoiler.setText(spoiler);
        txtGenre.setText(genre);
        txtReleased.setText(released);


    }
}
