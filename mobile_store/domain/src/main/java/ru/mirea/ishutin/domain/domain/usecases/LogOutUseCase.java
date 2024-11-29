package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.repository.AuthCallback;
import ru.mirea.ishutin.domain.domain.repository.AuthRepository;
import ru.mirea.ishutin.domain.domain.repository.UserRepository;

public class LogOutUseCase {

    private AuthRepository authRepository;

    public LogOutUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute(AuthCallback authCallback) {
        authRepository.signOut(authCallback);
    }

}
