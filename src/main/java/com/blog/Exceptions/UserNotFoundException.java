package com.blog.Exceptions;


public class UserNotFoundException extends RuntimeException {

    String message;
    public UserNotFoundException(Long id) {
        super("User with id: " + id + " not found");
        this.message="User with id: " + id + " not found";
    }
    public UserNotFoundException(String email) {
        super("User with email: " + email + " not found");
        this.message="User with id: " + email + " not found";
    }
}
