package com.afautos.main.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.afautos.main.models.user.Address;
import com.afautos.main.services.user.AddressService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/addAddress")
    public Address postMethodName(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @PostMapping("/getAllAddress")
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }
    
}
