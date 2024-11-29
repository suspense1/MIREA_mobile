package ru.mirea.ishutin.data.data.repository;

import java.util.List;

import ru.mirea.ishutin.data.data.repository.networkAPI.RemoteData;
import ru.mirea.ishutin.data.data.storage.ProductStorage;
import ru.mirea.ishutin.domain.domain.models.Product;
import ru.mirea.ishutin.domain.domain.repository.ApiCallback;
import ru.mirea.ishutin.domain.domain.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

    private RemoteData remoteData;

    public ProductRepositoryImpl(RemoteData remoteData) {
        this.remoteData = remoteData;
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
        return new Product();
    }

    @Override
    public void getAllProduct(ApiCallback<List<Product>> apiCallback) {
        remoteData.getProducts(apiCallback);
    }
}
