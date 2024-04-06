package com.blog.posts;

import com.blog.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    private UUID id;
    private String title;
    private String content;
    private String authorId;
    private String createdAt;
    private String updatedAt;
    private String categoryId;
    private String image;
    @ManyToOne
    private User author;
}
