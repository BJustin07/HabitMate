package com.BJustin07.HabitMate.Users.Controller;

import com.BJustin07.HabitMate.Users.Model.UserEntity;
import com.BJustin07.HabitMate.Users.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public UserEntity createUser(@RequestBody UserEntity user){
        userService.createUser(user);
        return user;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user){
        return userService.login(user);
    }
}
