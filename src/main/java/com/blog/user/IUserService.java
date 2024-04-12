package com.blog.user;

import com.blog.DTOs.CreateUserDTO;
import com.blog.DTOs.UpdateUserDTO;
import com.blog.DTOs.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    UserResponseDTO createUser(CreateUserDTO user);
    UserResponseDTO updateUser(UpdateUserDTO user) ;
    UserResponseDTO getUserByUserId(UUID username);
    List<UserResponseDTO> getAllUsers();
    void deleteUser(UUID userId);
    UserResponseDTO findUserByEmail(String email);
}
