package ru.mirea.ishutin.data.data.storage.models;

public class Product {
    private int id;
    private String name, price, localDate;

    public Product(int id, String name, String price, String localDate){
        this.id = id;
        this.name = name;
        this.price = price;
        this.localDate = localDate;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getPrice(){
        return price;
    }

    public String getLocalDate(){
        return localDate;
    }
}
