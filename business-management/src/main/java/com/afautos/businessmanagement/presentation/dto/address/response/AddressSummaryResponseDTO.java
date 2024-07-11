package com.afautos.businessmanagement.presentation.dto.address.response;

public record AddressSummaryResponseDTO(
        Integer id,
        String ref,
        String neighborhood,
        String city
) {
}
