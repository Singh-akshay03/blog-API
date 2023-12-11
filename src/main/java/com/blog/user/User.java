package com.blog.user;

import com.blog.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


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
}
