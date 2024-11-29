package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.repository.AuthRepository;
import ru.mirea.ishutin.domain.domain.repository.UserCallback;

public class GetUserDataUseCase {

    private AuthRepository authRepository;

    public GetUserDataUseCase(AuthRepository authRepository){
        this.authRepository = authRepository;
    }

    public void execute(String id, UserCallback userCallback) {
        authRepository.getUserInfo(id, userCallback);
    }

}
