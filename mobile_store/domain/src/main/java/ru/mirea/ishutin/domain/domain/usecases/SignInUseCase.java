package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.repository.AuthCallback;
import ru.mirea.ishutin.domain.domain.repository.AuthRepository;
import ru.mirea.ishutin.domain.domain.repository.UserRepository;

public class SignInUseCase {

    private AuthRepository authRepository;

    public SignInUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute(String username, String password, AuthCallback authCallback) {
        authRepository.signIn(username, password, authCallback);
    }

}
