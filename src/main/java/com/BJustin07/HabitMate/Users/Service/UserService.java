package com.BJustin07.HabitMate.Users.Service;

import com.BJustin07.HabitMate.Users.Model.UserEntity;

public interface UserService {
    public UserEntity createUser(UserEntity user);
    public String login(UserEntity user);
    public UserEntity findById(int id);
    public UserEntity findByUsername(String username);
    public boolean userExistsByUsername(String username);
}
