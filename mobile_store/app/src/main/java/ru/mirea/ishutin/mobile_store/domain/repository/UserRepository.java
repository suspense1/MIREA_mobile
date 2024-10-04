package ru.mirea.ishutin.mobile_store.domain.repository;

import ru.mirea.ishutin.mobile_store.domain.models.Product;
import ru.mirea.ishutin.mobile_store.domain.models.User;

public interface UserRepository {

    public boolean sign_in(String email, String password);
    public boolean sign_up(String name, String s_name, String email, String password);
    public User getUserData(int id);
    public  boolean log_out();
    public User[] getAllUsers();

}
