package com.blog.Exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long postId) {
        super("Post not found with the given post ID: "+postId);
    }
}
