package com.afautos.businessmanagement.services.implementation.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.presentation.dto.authentication.AuthLoginRequest;
import com.afautos.businessmanagement.presentation.dto.authentication.AuthResponse;
import com.afautos.businessmanagement.services.implementation.user.UserDetailServiceImpl;
import com.afautos.businessmanagement.services.interfaces.authentication.IAuthenticationService;

import jakarta.validation.Valid;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService{

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    public ResponseEntity<AuthResponse> login(@Valid AuthLoginRequest userRequest) {
        return new ResponseEntity<>(userDetailService.loginUser(userRequest), HttpStatus.OK);
    }
    
}
