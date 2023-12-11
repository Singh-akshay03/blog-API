package com.blog.Exceptions;

public class UserAlreadyExistsWithThisUserName extends Exception{
    public UserAlreadyExistsWithThisUserName(String message) {
        super(message);
    }
}
