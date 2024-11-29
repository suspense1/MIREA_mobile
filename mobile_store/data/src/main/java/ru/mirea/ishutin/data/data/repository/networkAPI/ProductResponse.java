package ru.mirea.ishutin.data.data.repository.networkAPI;

import java.util.List;

import ru.mirea.ishutin.domain.domain.models.Product;

public class ProductResponse {

    private List<Product> data;

    public List<Product> getData(){
        return data;
    }

    public void setData(List<Product> data){
        this.data = data;
    }

}
