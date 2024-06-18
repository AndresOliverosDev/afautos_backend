package com.afautos.businessmanagement.services.interfaces.user;

import java.util.List;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.presentation.dto.user.request.UserRequestDTO;
import com.afautos.businessmanagement.presentation.dto.user.response.UserDTO;

public interface IUserService {
    
    List<UserDTO> getAllUser();

    UserEntity getUserById(String id) throws LocalNotFoundException;

    ResponseEntity<String> addUser(UserRequestDTO userAdd);
}
