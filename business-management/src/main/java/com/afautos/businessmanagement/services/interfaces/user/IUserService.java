package com.afautos.businessmanagement.services.interfaces.user;

import java.util.List;

import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.presentation.dto.user.response.CustomerResponseDTO;
import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.presentation.dto.user.request.UserRequestDTO;
import com.afautos.businessmanagement.presentation.dto.user.response.UserDTO;

public interface IUserService {
    // Read
    List<UserDTO> getAllUser();

    List<CustomerResponseDTO> getAllCustomers();

    UserEntity getUserEntityById(String id);

    ResponseEntity<String> addUser(UserRequestDTO userAdd);
}
