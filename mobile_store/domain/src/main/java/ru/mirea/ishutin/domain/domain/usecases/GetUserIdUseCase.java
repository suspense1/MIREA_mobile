package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.repository.AuthRepository;

public class GetUserIdUseCase {

    private AuthRepository authRepository;

    public GetUserIdUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public String execute() {
        return authRepository.getUserId();
    }
}
