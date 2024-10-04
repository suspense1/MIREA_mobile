package ru.mirea.ishutin.mobile_store.domain.usecases;

import ru.mirea.ishutin.mobile_store.domain.models.User;
import ru.mirea.ishutin.mobile_store.domain.repository.UserRepository;

public class GetAllUsersUseCase {

    private UserRepository userRepository;

    public GetAllUsersUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User[] execute(){
        return userRepository.getAllUsers();
    }
}
