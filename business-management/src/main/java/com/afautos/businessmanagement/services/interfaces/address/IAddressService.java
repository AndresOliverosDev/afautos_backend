package com.afautos.businessmanagement.services.interfaces.address;

import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;

public interface IAddressService {
    AddressEntity createAddress(AddressRequestDTO addressRequestDTO);
}
