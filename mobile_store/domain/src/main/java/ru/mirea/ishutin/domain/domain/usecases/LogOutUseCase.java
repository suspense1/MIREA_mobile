package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.repository.UserRepository;

public class LogOutUseCase {

    private UserRepository userRepository;

    public  LogOutUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean execute(){
        return userRepository.log_out();
    }

}
