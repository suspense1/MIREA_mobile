package ru.mirea.ishutin.domain.domain.repository;

import ru.mirea.ishutin.domain.domain.models.User;

public interface UserCallback {

    void onSuccess(User user);
    void onError(String error);
}
