package ru.mirea.ishutin.data.data.repository;

import ru.mirea.ishutin.data.data.storage.UserStorage;
import ru.mirea.ishutin.domain.domain.models.User;
import ru.mirea.ishutin.domain.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    private UserStorage userStorage;

    public UserRepositoryImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public User getUserData(int id) {
        return User.getUser();
    }

    @Override
    public User[] getAllUsers() {
        return new User[] {User.getUser()};
    }
}
