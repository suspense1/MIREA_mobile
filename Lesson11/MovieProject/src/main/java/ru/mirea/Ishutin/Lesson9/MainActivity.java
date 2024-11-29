package ru.mirea.Ishutin.Lesson9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import ru.mirea.Ishutin.Lesson9.databinding.ActivityMainBinding;
import ru.mirea.ishutin.data.data.repository.MovieRepositoryImpl;
import ru.mirea.ishutin.data.data.storage.MovieStorage;
import ru.mirea.ishutin.data.data.storage.sharedprefs.SharedPrefMovieStorage;
import ru.mirea.ishutin.domain.domain.models.Movie;
import ru.mirea.ishutin.domain.domain.repository.MovieRepository;
import ru.mirea.ishutin.domain.domain.usecases.GetFavouriteFilmUseCase;
import ru.mirea.ishutin.domain.domain.usecases.SaveMovieToFavouriteUseCase;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new ViewModelFactory(this)).get(MainViewModel.class);

        EditText text = findViewById(R.id.input_movie_name);
        TextView textView = findViewById(R.id.data);

        viewModel.getFavoriteMovie().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(String.format("Save result: %s", s));
            }
        });

        findViewById(R.id.save_fav_movie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setText(new Movie(2, text.getText().toString()));
            }
        });

        findViewById(R.id.show_fav_movie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.getText();
            }
        });
    }

}