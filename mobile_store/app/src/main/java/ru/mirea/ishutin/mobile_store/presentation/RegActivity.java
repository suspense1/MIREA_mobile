package ru.mirea.ishutin.mobile_store.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ru.mirea.ishutin.data.data.repository.AuthRepositoryImpl;
import ru.mirea.ishutin.domain.domain.repository.AuthCallback;
import ru.mirea.ishutin.mobile_store.R;
import ru.mirea.ishutin.mobile_store.databinding.ActivityRegBinding;

public class RegActivity extends AppCompatActivity {

    private ActivityRegBinding binding;
    private final AuthViewModel viewModel = new AuthViewModel(new AuthRepositoryImpl());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.emailInput.getText().toString();
                String password = binding.passwordInput.getText().toString();
                viewModel.signUp(email, password, new AuthCallback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(), "Вы успешно зарегистрировались!", Toast.LENGTH_LONG).show();
                        Log.d("REG", "Success");
                    }

                    @Override
                    public void onError(String error) {
                        Log.d("REG", "Error: " + error);
                    }
                });
            }
        });

        binding.toAuthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}