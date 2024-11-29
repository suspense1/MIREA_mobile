package ru.mirea.ishutin.data.data.storage.models;

import java.util.Date;

public class User {

    private String id, name, email, password;
    private Date date_of_create;

    public User(String id, String name, String email, String password, Date date_of_create){
        this.id = id;
        this.name = name;
        this.email = email;
        this.date_of_create = date_of_create;
        this.password = password;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public Date getDOC(){
        return date_of_create;
    }




}
