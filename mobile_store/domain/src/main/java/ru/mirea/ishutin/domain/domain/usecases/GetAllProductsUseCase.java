package ru.mirea.ishutin.domain.domain.usecases;

import java.util.List;

import ru.mirea.ishutin.domain.domain.models.Product;
import ru.mirea.ishutin.domain.domain.repository.ApiCallback;
import ru.mirea.ishutin.domain.domain.repository.ProductRepository;

public class GetAllProductsUseCase {

    private ProductRepository productRepository;

    public GetAllProductsUseCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void execute(ApiCallback<List<Product>> apiCallback){
        productRepository.getAllProduct(apiCallback);
    }
}
