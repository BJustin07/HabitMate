package com.BJustin07.HabitMate.Users.Controller;

import com.BJustin07.HabitMate.Security.JwtUtil;
import com.BJustin07.HabitMate.Users.Model.DTO.UserDTO;
import com.BJustin07.HabitMate.Users.Model.UserEntity;
import com.BJustin07.HabitMate.Users.Repository.UserRepository;
import com.BJustin07.HabitMate.Users.Service.UserAuthService;
import com.BJustin07.HabitMate.Users.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserAuthService userAuthService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public UserController(UserService userService, AuthenticationManager authenticationManager,
                           UserAuthService userAuthService, UserRepository userRepository,
                           PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userAuthService = userAuthService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/auth/signin")
    public String authenticateUser(@RequestBody UserDTO userDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getUsername(),
                        userDTO.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    @PostMapping("/auth/signup")
    public String registerUser(@RequestBody UserDTO userDTO){
        if (userService.userExistsByUsername(userDTO.getUsername())){
            return "Username already exists";
        }
        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }
}
