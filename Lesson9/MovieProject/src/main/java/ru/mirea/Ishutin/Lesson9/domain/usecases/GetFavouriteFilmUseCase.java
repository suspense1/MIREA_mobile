package ru.mirea.Ishutin.Lesson9.domain.usecases;

import ru.mirea.Ishutin.Lesson9.domain.models.Movie;
import ru.mirea.Ishutin.Lesson9.domain.repository.MovieRepository;

public class GetFavouriteFilmUseCase {

    private MovieRepository movieRepository;

    public GetFavouriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute(){
        return movieRepository.getMovie();
    }
}
