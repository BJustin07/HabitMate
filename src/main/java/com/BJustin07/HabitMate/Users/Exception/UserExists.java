package com.BJustin07.HabitMate.Users.Exception;

public class UserExists extends RuntimeException {
    public UserExists(String message) {
        super(message);
    }
}
