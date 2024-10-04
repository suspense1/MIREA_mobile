package ru.mirea.ishutin.mobile_store.domain.models;

public class Product {

    private int id;
    private String name, price;
    boolean isFavourite, isInCart;

    public Product(int id, String name, String price, boolean isFav, boolean isInCart){
        this.id = id;
        this.name = name;
        this.price = price;
        this.isFavourite = isFav;
        this.isInCart = isInCart;
    }

    public static Product getProduct(){
        return new Product(1, "Кроссовки", "2700", true, false);
    }
}
