package com.afautos.businessmanagement.presentation.dto.user.request;

import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;

public record UserManagementResponseDTO(
        UserAddDTO user,
        AddressRequestDTO address
) {
}
