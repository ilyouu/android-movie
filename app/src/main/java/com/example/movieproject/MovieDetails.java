package com.example.movieproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity {

    ImageView movieImage;
    TextView movieName;
    Button playButton;

    String id ,name, image, fileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movieImage = findViewById(R.id.movie_image);
        movieName = findViewById(R.id.movie_name);
        playButton = findViewById(R.id.play_button);

        id = getIntent().getStringExtra("movieId");
        name = getIntent().getStringExtra("movieName");
        image = getIntent().getStringExtra("movieImageUrl");
        fileUrl = getIntent().getStringExtra("movieFileUrl");

        Glide.with(this).load(image).into(movieImage);
        movieName.setText(name);
    }
}