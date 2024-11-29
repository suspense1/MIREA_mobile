package ru.mirea.ishutin.mobile_store.presentation;

import ru.mirea.ishutin.domain.domain.repository.AuthCallback;
import ru.mirea.ishutin.domain.domain.repository.AuthRepository;

public class AuthViewModel {
    private final AuthRepository authRepository;

    public AuthViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void signIn(String email, String password, AuthCallback callback) {
        authRepository.signIn(email, password, callback);
    }

    public void signUp(String email, String password, AuthCallback callback){
        authRepository.signUp(email, password, callback);
    }

    public void signOut(AuthCallback callback) {
        authRepository.signOut(callback);
    }

    public boolean isUserLoggedIn() {
        return authRepository.isUserLoggedIn();
    }
}
