package ru.mirea.ishutin.data.data.repository;

import ru.mirea.ishutin.data.data.storage.ProductStorage;
import ru.mirea.ishutin.domain.domain.models.Product;
import ru.mirea.ishutin.domain.domain.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

    public ProductRepositoryImpl(ProductStorage productStorage) {
    }

    @Override
    public boolean addProductToFav(Product product) {
        return false;
    }

    @Override
    public boolean deleteFromFav(String id) {
        return true;
    }

    @Override
    public Product[] getFavProducts() {
        return new Product[] {Product.getProduct()};
    }

    @Override
    public boolean addProductToCart(Product product) {
        return false;
    }

    @Override
    public boolean deleteFromCart(String id) {
        return true;
    }

    @Override
    public Product[] getCartProducts() {
        return new Product[] {Product.getProduct()};
    }

    @Override
    public Product getProductData() {
        return new Product(3, "Масло", "450", true, true);
    }

    @Override
    public Product[] getAllProduct() {
        return new Product[] {Product.getProduct()};
    }
}
