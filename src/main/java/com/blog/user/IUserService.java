package com.blog.user;

import com.blog.DTOs.CreateUserDTO;
import com.blog.DTOs.UpdateUserDTO;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    User createUser(CreateUserDTO user);
    User updateUser(UpdateUserDTO user);
    User getUserByUserName(String username);
    User getUserByUserId(UUID username);
    List<User> getAllUsers();

    void deleteUser(UUID userId);
}
