package ru.mirea.ishutin.mobile_store.domain.models;

public class User {
    private int id;
    private String name, s_name, email, password;

    public User(int id, String name, String s_name, String email, String password){
        this.id = id;
        this.name = name;
        this.s_name = s_name;
        this.email = email;
        this.password = password;
    }

    public static User getUser(){
        return new User(0, "Ilya", "Ishutin", "IlyaIsh@gmail.com", "1234567");
    }
}
