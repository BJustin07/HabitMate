package com.BJustin07.HabitMate.Users.Service;

import com.BJustin07.HabitMate.Users.Exception.UserNotFound;
import com.BJustin07.HabitMate.Users.Model.UserEntity;
import com.BJustin07.HabitMate.Users.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserAuthService implements UserDetailsService {
    private UserService userService;
    public UserAuthService(UserService userService) {
        this.userService = userService;
    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        try{
            UserEntity user = userService.findByUsername(username);

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    Collections.emptyList()
            );
        }catch (UserNotFound e){
            throw new UsernameNotFoundException(e + ":" + username);
        }



    }
}
