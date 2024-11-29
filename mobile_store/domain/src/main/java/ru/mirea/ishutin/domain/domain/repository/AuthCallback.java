package ru.mirea.ishutin.domain.domain.repository;

public interface AuthCallback {
    void onSuccess();
    void onError(String error);
}
