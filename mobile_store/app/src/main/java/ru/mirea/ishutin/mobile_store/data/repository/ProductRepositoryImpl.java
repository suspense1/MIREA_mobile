package ru.mirea.ishutin.mobile_store.data.repository;

import ru.mirea.ishutin.mobile_store.domain.models.Product;
import ru.mirea.ishutin.mobile_store.domain.repository.ProductRepository;
import ru.mirea.ishutin.mobile_store.presentation.MainActivity;

public class ProductRepositoryImpl implements ProductRepository {

    public ProductRepositoryImpl(MainActivity mainActivity) {
    }

    @Override
    public boolean addProductToFav(Product product) {
        return true;
    }

    @Override
    public Product[] getFavProducts() {
        Product[] products = new Product[1];
        products[0] = new Product(1, "Мячик", "500", false, false);
        return products;
    }

    @Override
    public boolean addProductToCart(Product product) {
        return true;
    }

    @Override
    public Product[] getCartProducts() {
        Product[] carts = new Product[1];
        carts[0] = new Product(2, "Кроссовки", "2500", false, false);
        return carts;
    }

    @Override
    public Product getProductData() {
        return new Product(3, "Масло", "450", true, true);
    }

    @Override
    public Product[] getAllProduct() {
        Product[] all_products = new Product[1];
        all_products[0] = Product.getProduct();
        return all_products;
    }
}
