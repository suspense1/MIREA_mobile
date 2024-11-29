package ru.mirea.ishutin.domain.domain.models;

public class User {
    private String id;
    private String name, email, password;

    public User(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static User getUser(){
        return new User("0", "Ilya", "IlyaIsh@gmail.com");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
