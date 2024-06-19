package com.afautos.businessmanagement.presentation.dto.transaction.order.response;

import java.time.LocalDateTime;

public record OrderResponseDTO(
        Long id,
        LocalDateTime date,
        String state,
        String observations,
        Long saleId,
        String employee
) {
}
