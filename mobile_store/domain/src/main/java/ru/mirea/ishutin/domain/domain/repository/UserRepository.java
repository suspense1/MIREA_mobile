package ru.mirea.ishutin.domain.domain.repository;

import ru.mirea.ishutin.domain.domain.models.User;

public interface UserRepository {
    public User getUserData(int id);
    public User[] getAllUsers();

}
