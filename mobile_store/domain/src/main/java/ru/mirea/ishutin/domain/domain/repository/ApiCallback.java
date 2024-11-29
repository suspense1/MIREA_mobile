package ru.mirea.ishutin.domain.domain.repository;

public interface ApiCallback<T> {
    public void onSuccess(T result);
    public void onFailure(Exception e);
}
