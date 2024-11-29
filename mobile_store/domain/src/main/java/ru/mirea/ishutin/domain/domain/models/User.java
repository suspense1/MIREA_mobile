package ru.mirea.ishutin.domain.domain.models;

public class User {
    private String id;
    private String name, email, password;

    public User(String id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User getUser(){
        return new User("0", "Ilya", "IlyaIsh@gmail.com", "1234567");
    }
}
