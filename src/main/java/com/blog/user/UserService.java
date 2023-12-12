package com.blog.user;

import com.blog.Exceptions.NoUserExistWithTheEmail;
import com.blog.Exceptions.NoUserExistWithTheUserName;
import com.blog.Exceptions.UserAlreadyExistsWithThisEmail;
import com.blog.Exceptions.UserAlreadyExistsWithThisUserName;
import com.blog.dtos.CreateUserRequestDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(CreateUserRequestDTO createUserRequestDTO) throws UserAlreadyExistsWithThisUserName, UserAlreadyExistsWithThisEmail {
        //Check if user username already exists
        User userByUsername = userRepository.findByUserName(createUserRequestDTO.getUsername());
        if(userByUsername != null){
            throw new UserAlreadyExistsWithThisUserName("Username already exists with the user name: " + createUserRequestDTO.getUsername());
        }
        //Check if user email already exists
        User userByEmail = userRepository.findByEmail(createUserRequestDTO.getEmail());
        if(userByEmail != null){
            throw new UserAlreadyExistsWithThisEmail("Email already exists with the email: " + createUserRequestDTO.getEmail());
        }

        //TODO:Hash plain password sent by the user

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUserName(createUserRequestDTO.getUsername());
        user.setPassword(createUserRequestDTO.getPassword());
        user.setEmail(createUserRequestDTO.getEmail());
        user.setBio(createUserRequestDTO.getBio());
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

    public User getUserByUserName(String username) throws NoUserExistWithTheUserName {
        User user= userRepository.findByUserName(username);
        if(user == null){
            throw new NoUserExistWithTheUserName("User not found with the username: " + username);
        }
        return user;
    }

    public User getUserByEmail(String email) throws NoUserExistWithTheEmail {
        User user= userRepository.findByEmail(email);
        if(user == null){
            throw new NoUserExistWithTheEmail("User not found with the email: " + email);
        }
        return user;
    }
}
