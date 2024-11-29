package ru.mirea.ishutin.data.data.storage;


import ru.mirea.ishutin.data.data.storage.models.Movie;

public interface MovieStorage {
    public Movie get();
    public boolean save(Movie movie);
}
