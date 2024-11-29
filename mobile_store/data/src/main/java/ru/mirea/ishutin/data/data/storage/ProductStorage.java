package ru.mirea.ishutin.data.data.storage;

import ru.mirea.ishutin.data.data.storage.models.Product;

public interface ProductStorage {
    public Product get();
    public Product[] getFavs();
    public Product[] getCart();
    public Product[] getAll();
    public boolean save(Product product);
    public boolean addToFavs(Product product);
    public boolean addToCart(Product product);
}
