package ru.mirea.ishutin.mobile_store.domain.repository;

import ru.mirea.ishutin.mobile_store.domain.models.Product;

public interface ProductRepository {
    public boolean addProductToFav(Product product);
    public Product[] getFavProducts();
    public boolean addProductToCart(Product product);
    public Product[] getCartProducts();
    public Product getProductData();
    public Product[] getAllProduct();

}
