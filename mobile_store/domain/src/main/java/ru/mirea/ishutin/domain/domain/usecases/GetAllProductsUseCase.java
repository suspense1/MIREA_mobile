package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.models.Product;
import ru.mirea.ishutin.domain.domain.repository.ProductRepository;

public class GetAllProductsUseCase {

    private ProductRepository productRepository;

    public GetAllProductsUseCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product[] execute(){
        return productRepository.getAllProduct();
    }
}
