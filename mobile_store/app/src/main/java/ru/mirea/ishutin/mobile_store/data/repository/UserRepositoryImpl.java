package ru.mirea.ishutin.mobile_store.data.repository;

import ru.mirea.ishutin.mobile_store.domain.models.Product;
import ru.mirea.ishutin.mobile_store.domain.models.User;
import ru.mirea.ishutin.mobile_store.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    private User current_user;

    @Override
    public boolean sign_in(String email, String password) {
        return true;
    }

    @Override
    public boolean sign_up(String name, String s_name, String email, String password) {
            return true;
    }

    @Override
    public User getUserData(int id) {
        return User.getUser();
    }

    @Override
    public boolean log_out() {
        return true;
    }

    @Override
    public User[] getAllUsers() {
        User[] all_users = new User[1];
        all_users[0] = User.getUser();
        return all_users;
    }
}
