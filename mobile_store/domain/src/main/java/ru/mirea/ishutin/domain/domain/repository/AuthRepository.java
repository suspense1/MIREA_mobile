package ru.mirea.ishutin.domain.domain.repository;

public interface AuthRepository {
    void signIn(String email, String password, AuthCallback callback);

    void signUp(String email, String password, AuthCallback callback);
    void signOut(AuthCallback callback);
    boolean isUserLoggedIn();
}
