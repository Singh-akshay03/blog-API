package com.blog.user;

import com.blog.DTOs.CreateUserDTO;
import com.blog.DTOs.UpdateUserDTO;
import com.blog.Exceptions.UserDoNotExitsWithId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    UserServiceImpl userService;
    UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable UUID userId) throws UserDoNotExitsWithId {
        return ResponseEntity.ok(userService.getUserByUserId(userId));
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(CreateUserDTO user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PatchMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserDTO user) throws UserDoNotExitsWithId {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}
