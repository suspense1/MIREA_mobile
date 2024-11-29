package ru.mirea.ishutin.data.data.storage;


import ru.mirea.ishutin.data.data.storage.models.User;

public interface UserStorage {
    public User get();
    public boolean save(User user);
}
