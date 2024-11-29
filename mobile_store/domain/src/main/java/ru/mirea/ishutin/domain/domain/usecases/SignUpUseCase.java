package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.repository.AuthCallback;
import ru.mirea.ishutin.domain.domain.repository.AuthRepository;
import ru.mirea.ishutin.domain.domain.repository.UserRepository;

public class SignUpUseCase {

    private AuthRepository authRepository;

    public  SignUpUseCase(AuthRepository authRepository){
        this.authRepository = authRepository;
    }

    public void execute(String username, String password, AuthCallback authCallback) {
        authRepository.signUp(username, password, authCallback);
    }
}
