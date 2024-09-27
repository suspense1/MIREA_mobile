package ru.mirea.Ishutin.Lesson9.data.repository;

import android.content.SharedPreferences;

import ru.mirea.Ishutin.Lesson9.MainActivity;
import ru.mirea.Ishutin.Lesson9.domain.models.Movie;
import ru.mirea.Ishutin.Lesson9.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {


    public MovieRepositoryImpl(MainActivity mainActivity) {
    }

    @Override
    public boolean saveMovie(Movie movie){
        return true;
    }
    @Override
    public Movie getMovie(){
        return new Movie(1, "Game of throne");
    }
}
