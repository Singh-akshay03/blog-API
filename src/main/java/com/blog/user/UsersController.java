package com.blog.user;

import com.blog.Exceptions.UserAlreadyExistsWithThisEmail;
import com.blog.Exceptions.UserAlreadyExistsWithThisUserName;
import com.blog.dtos.CreateUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UsersController {
    private final UserService userService;

    public UsersController( @Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/create-user")
    public User createNewUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) throws UserAlreadyExistsWithThisUserName, UserAlreadyExistsWithThisEmail {
        return userService.createNewUser(createUserRequestDTO);
    }
}
