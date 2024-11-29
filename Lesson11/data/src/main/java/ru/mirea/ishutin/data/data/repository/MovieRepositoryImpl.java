package ru.mirea.ishutin.data.data.repository;


import java.time.LocalDate;

import ru.mirea.ishutin.data.data.storage.MovieStorage;
import ru.mirea.ishutin.data.data.storage.models.Movie;
import ru.mirea.ishutin.domain.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieStorage movieStorage;

    public MovieRepositoryImpl(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @Override
    public boolean saveMovie(ru.mirea.ishutin.domain.domain.models.Movie movie) {
        return movieStorage.save(mapToStorage(movie));
    }

    @Override
    public ru.mirea.ishutin.domain.domain.models.Movie getMovie() {
        return mapToDomain(movieStorage.get());
    }

    private Movie mapToStorage(ru.mirea.ishutin.domain.domain.models.Movie movie){
        String name = movie.getName();
        return new Movie(2, name, LocalDate.now().toString());
    }

    private ru.mirea.ishutin.domain.domain.models.Movie mapToDomain(Movie movie) {
        return new ru.mirea.ishutin.domain.domain.models.Movie(movie.getId(), movie.getName());
    }
}
