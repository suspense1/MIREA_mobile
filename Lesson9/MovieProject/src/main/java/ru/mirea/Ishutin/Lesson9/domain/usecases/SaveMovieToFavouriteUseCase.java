package ru.mirea.Ishutin.Lesson9.domain.usecases;

import ru.mirea.Ishutin.Lesson9.domain.models.Movie;
import ru.mirea.Ishutin.Lesson9.domain.repository.MovieRepository;

public class SaveMovieToFavouriteUseCase {
    private MovieRepository movieRepository;
    public SaveMovieToFavouriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}
