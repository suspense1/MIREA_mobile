package ru.mirea.ishutinis.layouttype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.mirea.ishutinis.layouttype.databinding.ActivityMainBinding;
import ru.mirea.ishutinis.layouttype.databinding.LinearLayoutBinding;

public class LinearLayout extends AppCompatActivity {

    private LinearLayoutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LinearLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}