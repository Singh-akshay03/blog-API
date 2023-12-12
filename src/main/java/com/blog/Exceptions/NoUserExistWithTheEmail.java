package com.blog.Exceptions;

public class NoUserExistWithTheEmail extends Exception {
    public NoUserExistWithTheEmail(String message) {
        super(message);
    }
}
