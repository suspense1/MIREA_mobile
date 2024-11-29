package ru.mirea.ishutin.data.data.repository.networkAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mirea.ishutin.domain.domain.models.Product;
import ru.mirea.ishutin.domain.domain.repository.ApiCallback;

public class RemoteData {
    private static final String URL = "https://free-e-store-api.onrender.com/api/v1/";
    private final ProductApi productApi;

    public RemoteData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        productApi = retrofit.create(ProductApi.class);
    }

    public void getProducts(ApiCallback<List<Product>> apiCallback){
        productApi.getProducts().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    apiCallback.onSuccess(response.body().getData().getProducts());
                }else{
                    apiCallback.onFailure(new Exception("Error"));
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                apiCallback.onFailure((Exception) t);
            }
        });
    }
}
