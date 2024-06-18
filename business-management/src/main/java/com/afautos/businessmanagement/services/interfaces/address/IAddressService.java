package com.afautos.businessmanagement.services.interfaces.address;

import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IAddressService {
    ResponseEntity<String> createAddress(AddressRequestDTO addressRequestDTO);
}
