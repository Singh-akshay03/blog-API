package com.blog.posts;

import com.blog.category.Category;
import com.blog.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100,nullable = false)
    private String title;
    @Column(length = 1000,nullable = false)
    private String content;
    @Column(length = 1000)
    private String image;
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;
}
