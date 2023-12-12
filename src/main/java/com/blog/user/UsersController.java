package com.blog.user;

import com.blog.Exceptions.NoUserExistWithTheEmail;
import com.blog.Exceptions.NoUserExistWithTheUserName;
import com.blog.Exceptions.UserAlreadyExistsWithThisEmail;
import com.blog.Exceptions.UserAlreadyExistsWithThisUserName;
import com.blog.dtos.CreateUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{username}")
    public User getUserByUserName(@PathVariable("username") String username) throws NoUserExistWithTheUserName {
        return userService.getUserByUserName(username);
    }

    @GetMapping(path = "/{email}")
    public User getUserByEmail(@PathVariable("email") String email) throws NoUserExistWithTheEmail {
        return userService.getUserByEmail(email);
    }
}
