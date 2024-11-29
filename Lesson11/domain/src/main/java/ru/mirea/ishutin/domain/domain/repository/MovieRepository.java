package ru.mirea.ishutin.domain.domain.repository;

import ru.mirea.ishutin.domain.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
