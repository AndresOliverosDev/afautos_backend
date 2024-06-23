package com.afautos.businessmanagement.services.interfaces.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderManagementResponseDTO;

import java.util.List;

public interface IOrderManagementService {
    // Read
    List<OrderManagementResponseDTO> getAllOrdersWithDetails();
}
