package com.afautos.businessmanagement.presentation.dto.transaction.order.response;

public record OrderDetailResponseDTO(
        Long id,
        Short quantity,
        Long productId,
        String productName,
        String productBrand,
        String productImage
) {
}
