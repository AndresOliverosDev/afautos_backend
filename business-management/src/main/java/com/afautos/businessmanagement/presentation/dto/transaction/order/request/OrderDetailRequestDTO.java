package com.afautos.businessmanagement.presentation.dto.transaction.order.request;

public record OrderDetailRequestDTO(
        Short quantity,
        Long productId
) {
}
