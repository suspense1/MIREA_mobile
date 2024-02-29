package ru.mirea.ishutinis.layouttype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.mirea.ishutinis.layouttype.databinding.ActivityMainBinding;
import ru.mirea.ishutinis.layouttype.databinding.TableLayoutBinding;

public class TableLayout extends AppCompatActivity {
    private TableLayoutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = TableLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}