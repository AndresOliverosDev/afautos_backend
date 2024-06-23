package com.afautos.businessmanagement.presentation.controller.address;

import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import com.afautos.businessmanagement.services.interfaces.address.IAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Direcciones", description = "El controlador de direcciones proporciona un endpoint para gestionar direcciones dentro del sistema.")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @Operation(summary = "Crear una nueva dirección", description = "Crea una nueva dirección en el sistema")
    @PostMapping("/createAddress")
    public ResponseEntity<String> createAddress(@RequestBody AddressRequestDTO address) {
        return addressService.createAddress(address);
    }
}
