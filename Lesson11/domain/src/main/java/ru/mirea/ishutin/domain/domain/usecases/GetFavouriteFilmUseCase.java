package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.models.Movie;
import ru.mirea.ishutin.domain.domain.repository.MovieRepository;

public class GetFavouriteFilmUseCase {

    private MovieRepository movieRepository;

    public GetFavouriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute(){
        return movieRepository.getMovie();
    }
}
