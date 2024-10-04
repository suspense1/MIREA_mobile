package ru.mirea.ishutin.mobile_store.domain.usecases;

import ru.mirea.ishutin.mobile_store.domain.models.User;
import ru.mirea.ishutin.mobile_store.domain.repository.UserRepository;

public class getUserDataUseCase {

    private UserRepository usersRepository;

    public getUserDataUseCase(UserRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public User execute(){
        return usersRepository.getUserData(0);
    }

}
