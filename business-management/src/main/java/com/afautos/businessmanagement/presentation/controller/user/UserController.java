package com.afautos.businessmanagement.presentation.controller.user;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.businessmanagement.presentation.dto.user.request.UserRequestDTO;
import com.afautos.businessmanagement.presentation.dto.user.response.UserDTO;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;

@Tag(name = "Usuarios", description = "El controlador de usuarios proporciona endpoints para gestionar usuarios dentro del sistema.")
@RestController
@RequestMapping("/user")
public class UserController {

    // Dependency injection
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Obtener todos los usuarios", description = "Recupera una lista de todos los usuarios disponibles en el sistema")
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/getAll")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @Operation(summary = "Agregar un nuevo usuario", description = "Agrega un nuevo usuario al sistema")
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserRequestDTO user) {
        return userService.addUser(user);
    }
}
