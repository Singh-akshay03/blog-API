package com.blog.user;

import com.blog.DTOs.CreateUserDTO;
import com.blog.DTOs.UserResponseDTO;
import com.blog.Exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDTO createUser(CreateUserDTO user) {
        User newUser = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .bio(user.getBio())
                .createdAt(new Date())
                .build();
        User savedUser = userRepository.save(newUser);
        return this.modelMapper.map(savedUser, UserResponseDTO.class);
    }


    @Override
    public UserResponseDTO updateUser(CreateUserDTO user, Long userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setUpdatedAt(new Date());
        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }
        if (user.getBio() != null) {
            existingUser.setBio(user.getBio());
        }
        return this.modelMapper.map(userRepository.save(existingUser), UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getUserByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        return this.modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user-> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
        userRepository.delete(user);
    }
}




