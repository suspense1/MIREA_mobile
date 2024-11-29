package ru.mirea.ishutin.data.data.repository.room;

import ru.mirea.ishutin.data.data.repository.room.models.Product;

public interface ProductDBcontroller {
    public void getProduct();
    public void addProduct(Product product);
    public void deleteProduct(String name);
}
