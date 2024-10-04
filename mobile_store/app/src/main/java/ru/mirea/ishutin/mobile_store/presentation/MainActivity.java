package ru.mirea.ishutin.mobile_store.presentation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.ishutin.mobile_store.R;
import ru.mirea.ishutin.mobile_store.data.repository.ProductRepositoryImpl;
import ru.mirea.ishutin.mobile_store.data.repository.UserRepositoryImpl;
import ru.mirea.ishutin.mobile_store.databinding.ActivityMainBinding;
import ru.mirea.ishutin.mobile_store.domain.models.Product;
import ru.mirea.ishutin.mobile_store.domain.models.User;
import ru.mirea.ishutin.mobile_store.domain.repository.ProductRepository;
import ru.mirea.ishutin.mobile_store.domain.repository.UserRepository;
import ru.mirea.ishutin.mobile_store.domain.usecases.GetCartProductsUseCase;
import ru.mirea.ishutin.mobile_store.domain.usecases.GetFavsProductsUseCase;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ProductRepository productRepository = new ProductRepositoryImpl(this);
        UserRepository userRepository = new UserRepositoryImpl(this);
    }
}