package com.afautos.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.main.models.User;
import com.afautos.main.services.UserService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/getByIdUser/{id}")
    public User getByIdUser(@PathVariable String id) {
        return userService.getByIdUser(id);
    };

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    };
    
}
