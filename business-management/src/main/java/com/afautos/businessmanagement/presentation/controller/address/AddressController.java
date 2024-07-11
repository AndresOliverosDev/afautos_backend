package com.afautos.businessmanagement.presentation.controller.address;

import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import com.afautos.businessmanagement.presentation.dto.address.response.AddressSummaryResponseDTO;
import com.afautos.businessmanagement.services.interfaces.address.IAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Direcciones", description = "El controlador de direcciones proporciona un endpoint para gestionar direcciones dentro del sistema.")
@RestController
@RequestMapping("/address")
public class AddressController {

    private final IAddressService addressService;

    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @Operation(summary = "Obtener direcciones por usuario", description = "Obtener información básica de las direcciones asociadas a un usuario dentro del sistema")
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/getAddressByUser/{userId}")
    public List<AddressSummaryResponseDTO> getAddressByUser(@PathVariable String userId) {
        return addressService.getAddressByUser(userId);
    }

    @Operation(summary = "Crear una nueva dirección", description = "Crea una nueva dirección en el sistema")
    @PreAuthorize("hasAuthority('CREATE') and (hasRole('CLIENTE') or hasRole('ADMIN'))")
    @PostMapping("/createAddress")
    public ResponseEntity<String> createAddress(@RequestBody AddressRequestDTO address) {
        return addressService.createAddress(address);
    }
}
