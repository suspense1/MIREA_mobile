package ru.mirea.ishutin.mobile_store.domain.usecases;

import ru.mirea.ishutin.mobile_store.domain.repository.UserRepository;

public class SignInUseCase {

    private UserRepository userRepository;

    public  SignInUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean execute(){
        return userRepository.sign_in("testmail@gmail.com", "1234567");
    }

}
