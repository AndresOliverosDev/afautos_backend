package com.afautos.businessmanagement.presentation.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.businessmanagement.presentation.dto.user.UserAddDTO;
import com.afautos.businessmanagement.presentation.dto.user.UserDTO;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/getAll")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserAddDTO userAdd) {
        return userService.addUser(userAdd);
    }
}
