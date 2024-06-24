package com.afautos.businessmanagement.presentation.controller.authentication;

import com.afautos.businessmanagement.presentation.dto.user.request.UserRequestDTO;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.businessmanagement.presentation.dto.authentication.request.AuthLoginRequest;
import com.afautos.businessmanagement.presentation.dto.authentication.response.AuthResponse;
import com.afautos.businessmanagement.services.interfaces.authentication.IAuthenticationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Autenticación", description = "El controlador de autenticación proporciona un endpoint para gestionar la autenticación de usuarios.")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    // Dependency injection
    private final IAuthenticationService authenticationService;
    private final IUserService userService;

    public AuthenticationController(IAuthenticationService authenticationService, IUserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @Operation(summary = "Iniciar sesión", description = "Autentica a un usuario y devuelve un token de acceso")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthLoginRequest authLoginRequest) {
        return authenticationService.login(authLoginRequest);
    }

    @Operation(summary = "Agregar un nuevo usuario", description = "Agrega un nuevo usuario al sistema")
    @PostMapping("/register")
    public ResponseEntity<String> addUser(@RequestBody UserRequestDTO user) {
        return userService.addUser(user);
    }
}
