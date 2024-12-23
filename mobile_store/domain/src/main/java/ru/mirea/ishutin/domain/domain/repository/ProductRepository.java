package ru.mirea.ishutin.domain.domain.repository;

import java.util.List;

import ru.mirea.ishutin.domain.domain.models.Product;

public interface ProductRepository {
    public boolean addProductToFav(Product product);
    public boolean deleteFromFav(String id);
    public boolean addProductToCart(Product product);
    public boolean deleteFromCart(String id);
    public Product[] getFavProducts();
    public Product[] getCartProducts();
    public Product getProductData();
    public void getAllProduct(ApiCallback<List<Product>> apiCallback);

}
