package ru.mirea.ishutin.domain.domain.usecases;

import ru.mirea.ishutin.domain.domain.models.User;
import ru.mirea.ishutin.domain.domain.repository.UserRepository;

public class GetAllUsersUseCase {

    private UserRepository userRepository;

    public GetAllUsersUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User[] execute(){
        return userRepository.getAllUsers();
    }
}
