package com.blog.article;

import com.blog.comment.Comment;
import com.blog.common.BaseEntity;
import com.blog.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity(name = "articles")
public class Article extends BaseEntity {
    @Column(length = 150)
    private String title;
    @Column(length = 180)
    private String slug;
    @Column(length = 200)
    private String subTitle;
    @Column(length = 1000,nullable = false)
    private String body;

    @ManyToOne
    private User author;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    @ManyToMany()
    List<User> likedBy;
}
