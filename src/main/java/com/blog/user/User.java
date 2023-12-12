package com.blog.user;

import com.blog.article.Article;
import com.blog.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;


@Getter
@Setter
@Entity(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false,unique = true,length = 30)
    private String userName;

    @Column(nullable = false,unique = true,length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 100)
    private String bio;

    @OneToMany(mappedBy = "author")
    private List<Article> article;


    @ManyToMany(targetEntity = User.class,mappedBy = "following")
    List<User> followers;

    @ManyToMany()
    List<User> following;

    @ManyToMany(targetEntity = Article.class,mappedBy = "likedBy")
    List<Article> favoriteArticles;
}
