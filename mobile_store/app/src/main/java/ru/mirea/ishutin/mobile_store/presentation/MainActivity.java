package ru.mirea.ishutin.mobile_store.presentation;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.mirea.ishutin.mobile_store.R;
import ru.mirea.ishutin.mobile_store.databinding.ActivityMainBinding;
import ru.mirea.ishutin.mobile_store.presentation.fragments.ProductsFragment;
import ru.mirea.ishutin.mobile_store.presentation.fragments.ProfileFragment;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView headerTitle = findViewById(R.id.header_title);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_products:
                        headerTitle.setText("Главная");
                        selectedFragment = new ProductsFragment();
                        break;
                    case R.id.nav_profile:
                        headerTitle.setText("Профиль");
                        selectedFragment = new ProfileFragment();
                        break;
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container_view, selectedFragment)
                            .commit();
                }

                return true;
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, new ProductsFragment())
                    .commit();
        }
    }
}