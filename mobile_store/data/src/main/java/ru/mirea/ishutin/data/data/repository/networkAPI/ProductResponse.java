package ru.mirea.ishutin.data.data.repository.networkAPI;

import java.util.List;

import ru.mirea.ishutin.domain.domain.models.Product;

public class ProductResponse {

    private String status;
    private int results;
    private DataResponse data;

    public String getStatus() {
        return status;
    }

    public int getResults() {
        return results;
    }

    public DataResponse getData() {
        return data;
    }
}
