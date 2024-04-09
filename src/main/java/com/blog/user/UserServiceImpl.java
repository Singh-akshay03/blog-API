package com.blog.user;

import com.blog.DTOs.CreateUserDTO;
import com.blog.DTOs.UpdateUserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {


    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(CreateUserDTO user) {
        User newUser = User.builder()
                .id(UUID.randomUUID())
                .name(user.getName())
                .password(user.getPassword())
                .type(user.getType())
                .email(user.getEmail())
                .build();
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(UpdateUserDTO user) {
        return null;
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findUserByName(username);
    }

    @Override
    public User getUserByUserId(UUID username) {
        return userRepository.findById(username).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}
