package ru.mirea.ishutin.mobile_store.presentation;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

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
        setSupportActionBar(binding.toolbar);

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(
                        R.id.nav_products,
                        R.id.nav_profile)
                        .build();

        NavController navController = Navigation.findNavController(
                this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this,
                navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navbar,
                navController);
    }
}