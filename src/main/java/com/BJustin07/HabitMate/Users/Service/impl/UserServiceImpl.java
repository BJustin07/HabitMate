package com.BJustin07.HabitMate.Users.Service.impl;

import com.BJustin07.HabitMate.Users.Exception.UserExists;
import com.BJustin07.HabitMate.Users.Exception.UserNotFound;
import com.BJustin07.HabitMate.Users.Model.UserEntity;
import com.BJustin07.HabitMate.Users.Repository.UserRepository;
import com.BJustin07.HabitMate.Users.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user){
        boolean userExists = userRepository.existsByUsername(user.getUsername());
        if(userExists){
            throw new UserExists(user.getUsername() +" already exists");
        }
        return userRepository.save(user);
    }
    public String login(UserEntity user){
        boolean correctUserCredentials = userRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(!correctUserCredentials){
            throw new UserNotFound("incorrect credentials");
        }
        return "logged in";
    }
    public UserEntity findById(int id){
        return userRepository.findById(id).
                orElseThrow(()->new UserNotFound("User not found"));
    }
}
