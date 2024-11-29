package ru.mirea.ishutin.mobile_store.presentation.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import ru.mirea.ishutin.data.data.repository.AuthRepositoryImpl;
import ru.mirea.ishutin.domain.domain.models.User;
import ru.mirea.ishutin.domain.domain.repository.AuthCallback;
import ru.mirea.ishutin.domain.domain.repository.UserCallback;
import ru.mirea.ishutin.domain.domain.usecases.GetUserDataUseCase;
import ru.mirea.ishutin.domain.domain.usecases.GetUserIdUseCase;
import ru.mirea.ishutin.domain.domain.usecases.LogOutUseCase;
import ru.mirea.ishutin.mobile_store.R;
import ru.mirea.ishutin.mobile_store.presentation.MainActivity;
import ru.mirea.ishutin.mobile_store.presentation.RegActivity;

public class ProfileFragment extends Fragment {

    private GetUserIdUseCase getUserIdUseCase;
    private GetUserDataUseCase getUserDataUseCase;
    private LogOutUseCase logOutUseCase;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AuthRepositoryImpl authRepository = new AuthRepositoryImpl();
        getUserIdUseCase = new GetUserIdUseCase(authRepository);
        getUserDataUseCase = new GetUserDataUseCase(authRepository);
        logOutUseCase = new LogOutUseCase(authRepository);

        TextView idTextView = view.findViewById(R.id.id_text_view);
        TextView mailTextView = view.findViewById(R.id.mail_text_view);

        String id = getUserIdUseCase.execute();
        getUserDataUseCase.execute(id, new UserCallback() {
            @Override
            public void onSuccess(User user) {
                idTextView.setText(id);
                mailTextView.setText(user.getEmail());
            }

            @Override
            public void onError(String error) {
                Log.d("MAIN", error);
                Toast.makeText(requireContext(), "Error getting user", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.sign_out_button).setOnClickListener(v -> {
            logOutUseCase.execute(new AuthCallback() {
                @Override
                public void onSuccess() {
                    Intent intent = new Intent(requireContext(), RegActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onError(String error) {
                    Log.d("MAIN", error);
                    Toast.makeText(requireContext(), "Error logging out", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}