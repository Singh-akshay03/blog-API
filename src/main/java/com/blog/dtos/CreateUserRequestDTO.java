package com.blog.dtos;

import lombok.Data;

@Data
public class CreateUserRequestDTO {
    private String username;
    private String password;
    private String email;
    private String bio;
}
