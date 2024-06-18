package com.afautos.businessmanagement.presentation.dto.address.request;

public record AddressRequestDTO(
        String ref,
        Integer neighborhoodId,
        String userId
) {

}
