package com.example.movie_catalogue;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TypedArray dataPhoto;
    private String[] dataTitle;
    private String [] dataSpoiler;
    private String [] dataGenre;
    private String [] dataReleased;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, movies.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                intent.putExtra( "KEY_EXTRA", movies.get(position ));
                startActivity(intent);
            }
        });
    }
    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i <dataTitle.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setSpoiler(dataSpoiler[i]);
            movie.setGenre(dataGenre[i]);
            movie.setReleased(dataReleased[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
    private void prepare(){
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataSpoiler = getResources().getStringArray(R.array.data_spoiler);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataReleased = getResources().getStringArray(R.array.data_released);
    }
}
