package ru.mirea.ishutin.data.data.repository.networkAPI;

import java.util.List;

import ru.mirea.ishutin.domain.domain.models.Product;

public class DataResponse {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}
