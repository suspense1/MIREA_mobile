package ru.mirea.ishutin.data.data.repository.networkAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {

    @GET("products")
    Call<ProductResponse> getProducts();
}
