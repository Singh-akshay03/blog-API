package com.blog.comments;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    private String id;
    private String content;
    private String authorId;
    private String postId;
    private Date createdAt;
    private Date updatedAt;


}
