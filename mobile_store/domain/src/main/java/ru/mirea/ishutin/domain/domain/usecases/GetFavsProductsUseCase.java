package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.models.Product;
import ru.mirea.ishutin.domain.domain.repository.ProductRepository;

public class GetFavsProductsUseCase {

    private ProductRepository productRepository;

    public GetFavsProductsUseCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product[] execute(){
        return productRepository.getFavProducts();
    }
}
