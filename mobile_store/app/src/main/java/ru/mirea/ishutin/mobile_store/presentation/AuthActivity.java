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
import ru.mirea.ishutin.domain.domain.usecases.IsUserLoggedUseCase;
import ru.mirea.ishutin.domain.domain.usecases.SignInUseCase;
import ru.mirea.ishutin.mobile_store.R;
import ru.mirea.ishutin.mobile_store.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {

    private ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AuthRepositoryImpl authRepository = new AuthRepositoryImpl();
        SignInUseCase signInUseCase = new SignInUseCase(authRepository);

        IsUserLoggedUseCase isUserLoggedUseCase = new IsUserLoggedUseCase(authRepository);
        if (isUserLoggedUseCase.execute()) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        binding.signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.emailInput.getText().toString();
                String password = binding.passwordInput.getText().toString();
                signInUseCase.execute(email, password, new AuthCallback() {
                    @Override
                    public void onSuccess() {
                        Log.d("AUTH", "Success");

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(getApplicationContext(), "Auth failure", Toast.LENGTH_LONG).show();
                        Log.d("AUTH", "Error: " + error);
                    }
                });
            }
        });

        binding.toRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}