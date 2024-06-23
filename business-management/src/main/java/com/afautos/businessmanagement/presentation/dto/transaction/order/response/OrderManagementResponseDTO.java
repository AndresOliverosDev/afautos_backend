package com.afautos.businessmanagement.presentation.dto.transaction.order.response;

import java.util.List;

public record OrderManagementResponseDTO(
        OrderResponseDTO order,
        List<OrderDetailResponseDTO> orderDetail
) {
}
