package com.afautos.main.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.main.dto.user.UserDTO;
import com.afautos.main.services.user.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }
}
