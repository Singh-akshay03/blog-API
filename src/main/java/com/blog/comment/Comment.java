package com.blog.comment;

import com.blog.article.Article;
import com.blog.common.BaseEntity;
import com.blog.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "comments")
public class Comment extends BaseEntity {
    @Column(length = 100)
    private String title;
    @Column(length = 1000,nullable = false)
    private String body;

    @ManyToOne
    private User author;

    @ManyToOne
    private Article article;
}
