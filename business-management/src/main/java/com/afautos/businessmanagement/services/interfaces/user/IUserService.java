package com.afautos.businessmanagement.services.interfaces.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.presentation.dto.user.UserAddDTO;
import com.afautos.businessmanagement.presentation.dto.user.UserDTO;

public interface IUserService {
    
    List<UserDTO> getAllUser();

    ResponseEntity<String> addUser(UserAddDTO userAdd);
}
