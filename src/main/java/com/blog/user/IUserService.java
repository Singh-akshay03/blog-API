package com.blog.user;

import com.blog.DTOs.CreateUserDTO;
import com.blog.DTOs.UpdateUserDTO;
import com.blog.Exceptions.UserDoNotExitsWithId;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    User createUser(CreateUserDTO user);
    User updateUser(UpdateUserDTO user) throws UserDoNotExitsWithId;
    User getUserByUserId(UUID username);
    List<User> getAllUsers();
    void deleteUser(UUID userId);
    User findUserByEmail(String email);
}
