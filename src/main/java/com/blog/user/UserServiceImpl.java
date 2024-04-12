package com.blog.user;

import com.blog.DTOs.CreateUserDTO;
import com.blog.DTOs.UpdateUserDTO;
import com.blog.DTOs.UserResponseDTO;
import com.blog.Exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {


    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(CreateUserDTO user) {
        User newUser = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .type(user.getType())
                .createdAt(new Date())
                .bio(user.getBio())
                .build();
        User userResponse= userRepository.save(newUser);
        return convertToUserResponseDTO(userResponse);
    }

    @Override
    public UserResponseDTO updateUser(UpdateUserDTO user) {
        User userToUpdate = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException(user.getId()));
        User updatedUser = User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(userToUpdate.getPassword())
                .type(user.getType())
                .bio(user.getBio())
                .createdAt(userToUpdate.getCreatedAt())
                .build();
        return convertToUserResponseDTO(userRepository.save(updatedUser));
    }

    @Override
    public UserResponseDTO getUserByUserId(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return convertToUserResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToUserResponseDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.delete(user);
    }

    @Override
    public UserResponseDTO findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UserNotFoundException(email);
        }
        return this.convertToUserResponseDTO(user);
    }

    public UserResponseDTO convertToUserResponseDTO(User user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .type(user.getType())
                .bio(user.getBio())
                .build();
    }
}
