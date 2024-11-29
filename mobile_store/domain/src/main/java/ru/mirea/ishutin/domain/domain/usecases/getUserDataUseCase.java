package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.models.User;
import ru.mirea.ishutin.domain.domain.repository.UserRepository;

public class getUserDataUseCase {

    private UserRepository usersRepository;

    public getUserDataUseCase(UserRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public User execute(){
        return usersRepository.getUserData(0);
    }

}
