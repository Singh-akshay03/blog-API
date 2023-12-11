package com.blog.Exceptions;

public class UserAlreadyExistsWithThisEmail extends Exception{
    public UserAlreadyExistsWithThisEmail(String message) {
        super(message);
    }
}
