package com.afautos.businessmanagement.presentation.controller.address;

import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import com.afautos.businessmanagement.services.interfaces.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/createAddress")
    public ResponseEntity<String> createAddress(@RequestBody AddressRequestDTO address) {
        return addressService.createAddress(address);
    }
}
