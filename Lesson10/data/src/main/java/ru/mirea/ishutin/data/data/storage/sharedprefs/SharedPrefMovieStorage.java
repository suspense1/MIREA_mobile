package ru.mirea.ishutin.data.data.storage.sharedprefs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.time.LocalDate;

import ru.mirea.ishutin.data.data.storage.MovieStorage;
import ru.mirea.ishutin.data.data.storage.models.Movie;


public class SharedPrefMovieStorage  implements MovieStorage {

    private static final String SHARED_PREFS_NAME = "film_info";
    private static final String KEY = "fav_film";
    private static final String DATE_KEY = "movie_date";
    private static final String ID_KEY = "movie_id";
    private SharedPreferences sharedPreferences;
    private Context context;
    public SharedPrefMovieStorage(Context context1) {
        context = context1;
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Movie get() {
        String movieName = sharedPreferences.getString(KEY, "Interstellar");
        String movieDate = sharedPreferences.getString(DATE_KEY, String.valueOf(LocalDate.now()));
        int movieId = sharedPreferences.getInt(ID_KEY, -1);
        return new Movie(movieId, movieName, movieDate);

    }

    @Override
    public boolean save(Movie movie) {
        sharedPreferences.edit().putString(KEY, movie.getName());
        sharedPreferences.edit().putString(DATE_KEY, String.valueOf(LocalDate.now()));
        sharedPreferences.edit().putInt(ID_KEY, 1);
        sharedPreferences.edit().apply();
        return false;
    }


}
