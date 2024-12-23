package ru.mirea.Ishutin.Lesson9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import ru.mirea.Ishutin.Lesson9.databinding.ActivityMainBinding;
import ru.mirea.ishutin.data.data.repository.MovieRepositoryImpl;
import ru.mirea.ishutin.data.data.storage.MovieStorage;
import ru.mirea.ishutin.data.data.storage.sharedprefs.SharedPrefMovieStorage;
import ru.mirea.ishutin.domain.domain.models.Movie;
import ru.mirea.ishutin.domain.domain.repository.MovieRepository;
import ru.mirea.ishutin.domain.domain.usecases.GetFavouriteFilmUseCase;
import ru.mirea.ishutin.domain.domain.usecases.SaveMovieToFavouriteUseCase;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MovieStorage sharedPrefMovieStorage = new SharedPrefMovieStorage(this);
        MovieRepository movieRepository = new MovieRepositoryImpl(sharedPrefMovieStorage);

//        MovieRepository movieRepository = new MovieRepositoryImpl(this);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        String empty_msg = "Нет данных!";


        binding.saveFavMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = new SaveMovieToFavouriteUseCase(movieRepository).execute(new Movie(2, binding.inputMovieName.getText().toString()));
                binding.data.setText(String.format("Save result %s", result));
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("name", binding.inputMovieName.getText().toString());
                editor.apply();
            }
        });

        binding.showFavMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movie_name = sharedPref.getString("name", empty_msg);
                Log.d("MSG", movie_name);
                if (movie_name.equals(empty_msg)){
                    Movie movie = new GetFavouriteFilmUseCase(movieRepository).execute();
                    binding.data.setText(String.format("Save result %s", movie.getName()));
                }else{
                    binding.data.setText(movie_name);
                }
            }
        });
    }
}