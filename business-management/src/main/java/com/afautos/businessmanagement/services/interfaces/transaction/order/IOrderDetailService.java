package com.afautos.businessmanagement.services.interfaces.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;

import java.util.List;

public interface IOrderDetailService {
    // Read
    List<OrderDetailResponseDTO> getOrderDetailsByOrder(Long orderId);
}
