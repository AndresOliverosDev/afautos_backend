package com.afautos.businessmanagement.presentation.dto.transaction.order.request;

public record OrderRequestDTO(
        String state,
        String observations,
        Long saleId,
        String employeeId
) {
}
