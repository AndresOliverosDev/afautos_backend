package com.afautos.businessmanagement.services.interfaces.authentication;

import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.presentation.dto.authentication.request.AuthLoginRequest;
import com.afautos.businessmanagement.presentation.dto.authentication.response.AuthResponse;

public interface IAuthenticationService {
    ResponseEntity<AuthResponse> login(AuthLoginRequest userRequest);
}
