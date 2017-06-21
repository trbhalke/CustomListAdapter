package com.test.customlistadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    int[] movieImages = {R.drawable.alien_cov, R.drawable.beauty_n_beast,
            R.drawable.fnf, R.drawable.guardians,
            R.drawable.justice, R.drawable.kongskull,
            R.drawable.logan, R.drawable.spiderman,
            R.drawable.starwars, R.drawable.thor};
    private ListView listView;
    private String[] movie_title;
    private String[] movie_Collections;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listMovies);

        movie_title = getResources().getStringArray(R.array.movietitle);
        movie_Collections = getResources().getStringArray(R.array.collections);

        movieAdapter = new MovieAdapter(getApplicationContext(), R.layout.movies_list, movieImages, movie_title, movie_Collections);
        listView.setAdapter(movieAdapter);

    }
}
