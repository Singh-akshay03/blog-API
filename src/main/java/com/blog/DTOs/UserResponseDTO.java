package com.blog.DTOs;

import com.blog.user.UserType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class UserResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private UserType type;
    private String bio;
}
