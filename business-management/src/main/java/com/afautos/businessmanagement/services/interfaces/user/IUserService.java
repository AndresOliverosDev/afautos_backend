package com.afautos.businessmanagement.services.interfaces.user;

import java.util.List;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.presentation.dto.user.request.UserAddDTO;
import com.afautos.businessmanagement.presentation.dto.user.response.UserDTO;

public interface IUserService {
    
    List<UserDTO> getAllUser();

    UserEntity getUserById(String id) throws LocalNotFoundException;

    ResponseEntity<String> addUser(UserAddDTO userAdd);
}
