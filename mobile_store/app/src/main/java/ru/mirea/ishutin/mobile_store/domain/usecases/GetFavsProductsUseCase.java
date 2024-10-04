package ru.mirea.ishutin.mobile_store.domain.usecases;

import ru.mirea.ishutin.mobile_store.domain.models.Product;
import ru.mirea.ishutin.mobile_store.domain.repository.ProductRepository;

public class GetFavsProductsUseCase {

    private ProductRepository productRepository;

    public GetFavsProductsUseCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product[] execute(){
        return productRepository.getFavProducts();
    }
}
