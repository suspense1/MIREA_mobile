package ru.mirea.ishutin.mobile_store.domain.usecases;

import ru.mirea.ishutin.mobile_store.domain.models.Product;
import ru.mirea.ishutin.mobile_store.domain.repository.ProductRepository;

public class GetProductDataUseCase {

    private ProductRepository productRepository;

    public GetProductDataUseCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product execute(){
        return productRepository.getProductData();
    }
}
