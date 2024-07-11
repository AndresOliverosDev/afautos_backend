package com.afautos.businessmanagement.services.interfaces.address;

import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import com.afautos.businessmanagement.presentation.dto.address.response.AddressSummaryResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAddressService {

    // Read

    List<AddressSummaryResponseDTO> getAddressByUser(String userId);

    ResponseEntity<String> createAddress(AddressRequestDTO addressRequestDTO);
}
