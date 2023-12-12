package com.blog.Exceptions;

public class NoUserExistWithTheUserName extends Exception
{
    public NoUserExistWithTheUserName(String message) {
        super(message);
    }
}
