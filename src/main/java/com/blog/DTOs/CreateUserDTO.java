package com.blog.DTOs;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserDTO {
    @NotBlank(message = "Name is required to create a user")
    private String name;
    @NotBlank(message = "Email is required to create a user")
    private String email;
    private String password;
    private String bio;
}
