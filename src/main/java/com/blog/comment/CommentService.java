package com.blog.comment;

import com.blog.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService( @Autowired CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

}
