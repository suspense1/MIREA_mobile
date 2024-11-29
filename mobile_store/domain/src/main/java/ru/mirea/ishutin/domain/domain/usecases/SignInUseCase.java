package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.repository.UserRepository;

public class SignInUseCase {

    private UserRepository userRepository;

    public  SignInUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean execute(){
        return userRepository.sign_in("testmail@gmail.com", "1234567");
    }

}
