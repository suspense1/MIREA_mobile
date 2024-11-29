package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.models.Movie;
import ru.mirea.ishutin.domain.domain.repository.MovieRepository;

public class SaveMovieToFavouriteUseCase {
    private MovieRepository movieRepository;
    public SaveMovieToFavouriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}
