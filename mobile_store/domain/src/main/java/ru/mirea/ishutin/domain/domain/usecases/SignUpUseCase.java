package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.repository.UserRepository;

public class SignUpUseCase {

    private UserRepository userRepository;

    public  SignUpUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean execute(){
        return userRepository.sign_up("Ilya", "Ishutin", "testmail@gmail.com", "1234567");
    }
}
