package com.enigma.controller;

import com.enigma.entity.User;
import com.enigma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @CrossOrigin
    @GetMapping("/user/{idUser}")
    public User getUserById(@PathVariable String idUser) {
        return userService.getUserById(idUser);
    }

    @CrossOrigin
    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @CrossOrigin
    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUserById(user);
    }

    @CrossOrigin
    @DeleteMapping("/user/{idUser}")
    public void deleteUser(@PathVariable String idUser) {
        userService.deleteUserById(idUser);
    }


}
