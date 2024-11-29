package ru.mirea.ishutin.mobile_store.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.ishutin.data.data.repository.ProductRepositoryImpl;
import ru.mirea.ishutin.data.data.repository.UserRepositoryImpl;
import ru.mirea.ishutin.data.data.storage.ProductStorage;
import ru.mirea.ishutin.data.data.storage.UserStorage;
import ru.mirea.ishutin.data.data.storage.sharedprefs.SharedPrefProductStorage;
import ru.mirea.ishutin.data.data.storage.sharedprefs.SharedPrefUserStorage;
import ru.mirea.ishutin.domain.domain.repository.ProductRepository;
import ru.mirea.ishutin.domain.domain.repository.UserRepository;
import ru.mirea.ishutin.mobile_store.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        ProductRepository productRepository = new ProductRepositoryImpl(this);
//        UserRepository userRepository = new UserRepositoryImpl(this);

        ProductStorage sharedPrefProductStorage = new SharedPrefProductStorage(this);
        ProductRepository productRepository = (ProductRepository) new ProductRepositoryImpl(sharedPrefProductStorage);

        UserStorage sharedPrefUserStorage = new SharedPrefUserStorage(this);
        UserRepository userRepository = (UserRepository) new UserRepositoryImpl(sharedPrefUserStorage);
    }
}