package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.repository.AuthRepository;

public class IsUserLoggedUseCase {

    private AuthRepository authRepository;

    public IsUserLoggedUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public boolean execute() {
        return authRepository.isUserLoggedIn();
    }
}
