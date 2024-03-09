package com.afautos.main.services;

import org.springframework.stereotype.Service;

import com.afautos.main.models.Address;

@Service
public interface AddressService {
    Address addAddress(Address address);
}
