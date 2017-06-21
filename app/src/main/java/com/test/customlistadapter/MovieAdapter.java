package com.test.customlistadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tukaram on 21-03-2017.
 */

public class MovieAdapter extends ArrayAdapter {
    Context context;
    int[] movieImages;
    String[] movie_title;
    String[] movie_Collections;


    public MovieAdapter(Context context, int resource, int[] movieImages, String[] movie_title, String[] movie_Collections) {
        super(context, resource);
        this.context = context;
        this.movieImages = movieImages;
        this.movie_title = movie_title;
        this.movie_Collections = movie_Collections;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Handler handler = new Handler();
        view = convertView;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.movies_list, parent, false);
            handler.imageView = (ImageView) view.findViewById(R.id.images);
            handler.textViewTitle = (TextView) view.findViewById(R.id.titleMovie);
            handler.textViewCollections = (TextView) view.findViewById(R.id.collections);
            view.setTag(handler);
        } else {
            handler = (Handler) view.getTag();
        }
        handler.imageView.setImageResource(movieImages[position]);
        handler.textViewTitle.setText(movie_title[position]);
        handler.textViewCollections.setText(movie_Collections[position]);
        return view;
    }

    @Override
    public int getCount() {
        return movieImages.length;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return movieImages[position];
    }

    static class Handler {
        private ImageView imageView;
        private TextView textViewTitle, textViewCollections;


    }
}
