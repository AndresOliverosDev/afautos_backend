package com.afautos.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afautos.main.models.Address;

@Service
public interface AddressService {

    Address addAddress(Address address);

    Address deleteAddress(Integer id);

    Address updateAddress(Integer id, Address address);

    List<Address> getAllAddress();

    Address getByIdAddress(Integer id);
}
