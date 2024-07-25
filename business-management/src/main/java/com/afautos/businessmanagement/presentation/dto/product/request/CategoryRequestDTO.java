package com.afautos.businessmanagement.presentation.dto.product.request;

import org.springframework.lang.NonNull;

public record CategoryRequestDTO(
    @NonNull String name,
    @NonNull String description
) {
    
}
