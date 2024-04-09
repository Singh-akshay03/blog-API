package com.blog.DTOs;

import com.blog.user.UserType;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateUserDTO {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private UserType type;
}
