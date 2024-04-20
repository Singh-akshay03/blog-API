package com.blog.user;

import com.blog.posts.Post;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(nullable = false, length = 15)
    private String password;
    @Column(nullable = false)
    private String bio;
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> postList=new ArrayList<>();
}
