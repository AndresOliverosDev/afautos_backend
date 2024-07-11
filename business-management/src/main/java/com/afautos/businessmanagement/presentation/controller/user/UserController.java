package com.afautos.businessmanagement.presentation.controller.user;

import java.util.List;

import com.afautos.businessmanagement.presentation.dto.address.response.AddressSummaryResponseDTO;
import com.afautos.businessmanagement.presentation.dto.user.response.CustomerResponseDTO;
import com.afautos.businessmanagement.services.interfaces.address.IAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.afautos.businessmanagement.presentation.dto.user.response.UserDTO;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;

@Tag(name = "Usuarios", description = "El controlador de usuarios proporciona endpoints para gestionar usuarios dentro del sistema.")
@RestController
@RequestMapping("/user")
public class UserController {

    // Dependency injection
    private final IUserService userService;
    private final IAddressService addressService;

    public UserController(IUserService userService, IAddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    // Read

    @Operation(summary = "Obtener todos los clientes", description = "Recupera una lista de todos los clientes disponibles en el sistema")
    @PreAuthorize("hasRole('ADMIN') or hasRole('VENTAS')")
    @GetMapping("/getAllCustomers")
    public List<CustomerResponseDTO> getAllCustomers() {
        return userService.getAllCustomers();
    }

    @Operation(summary = "Obtener todos los usuarios", description = "Recupera una lista de todos los usuarios disponibles en el sistema")
    @PreAuthorize("hasRole('ADMIN') or hasRole('VENTAS')")
    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }
}
