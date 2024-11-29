package ru.mirea.ishutin.mobile_store.presentation.viewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.ishutin.data.data.repository.ProductRepositoryImpl;
import ru.mirea.ishutin.data.data.repository.networkAPI.RemoteData;
import ru.mirea.ishutin.domain.domain.models.Product;
import ru.mirea.ishutin.domain.domain.repository.ApiCallback;
import ru.mirea.ishutin.domain.domain.usecases.GetAllProductsUseCase;

public class MainActivityViewModel extends ViewModel {

    private GetAllProductsUseCase getAllProductsUseCase;

    private RemoteData remoteDataSource;

    private MutableLiveData<List<Product>> allProducts = new MutableLiveData<>();
    private MediatorLiveData<List<Product>> allProductsLiveData = new MediatorLiveData<>();

    private final Context context;

    public MainActivityViewModel(Context context) {
        this.context = context;

        remoteDataSource = new RemoteData();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl(remoteDataSource);

        getAllProductsUseCase = new GetAllProductsUseCase(productRepository);

        allProductsLiveData.addSource(allProducts, products -> {
            getAllProductsLiveData(products);
        });
    }

    private void getAllProductsLiveData(List<Product> products) {
        allProductsLiveData.setValue(products);
    }

    public void getAllProducts() {
        getAllProductsUseCase.execute(new ApiCallback<List<Product>>() {
            @Override
            public void onSuccess(List<Product> result) {
                allProducts.setValue(result);
                Log.d("MAIN_ACTIVITY_VIEW_MODEL", "SUCCESS, " + result.size());
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("MAIN_ACTIVITY_VIEW_MODEL", e.getMessage());
            }
        });
    }

    public MediatorLiveData<List<Product>> getProductsLiveData() {
        return allProductsLiveData;
    }
}
