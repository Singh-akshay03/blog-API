package com.blog.user;

import com.blog.DTOs.CreateUserDTO;
import com.blog.DTOs.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    UserResponseDTO createUser(CreateUserDTO user);
    UserResponseDTO updateUser(CreateUserDTO user,Long userId) ;
    UserResponseDTO getUserByUserId(Long userId);
    List<UserResponseDTO> getAllUsers();
    void deleteUser(Long userId);
}
