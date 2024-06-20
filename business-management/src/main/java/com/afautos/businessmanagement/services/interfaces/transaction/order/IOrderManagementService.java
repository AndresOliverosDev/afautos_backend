package com.afautos.businessmanagement.services.interfaces.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderDetailRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderManagementResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderManagementService {
    // Read
    List<OrderManagementResponseDTO> getAllOrderWithDetails();
    // Create
    ResponseEntity<String> createOrderWithDetails(OrderRequestDTO orderRequestDTO, List<OrderDetailRequestDTO> orderDetailRequestDTO);
}
