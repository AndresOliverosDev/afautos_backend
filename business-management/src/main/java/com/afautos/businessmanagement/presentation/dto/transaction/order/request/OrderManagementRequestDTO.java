package com.afautos.businessmanagement.presentation.dto.transaction.order.request;

import java.util.List;

public record OrderManagementRequestDTO (
        OrderRequestDTO order,
        List<OrderDetailRequestDTO> orderDetails
) {
}
