package com.afautos.businessmanagement.services.interfaces.transaction.order;

import com.afautos.businessmanagement.persistence.entity.transaction.order.OrderEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderService {
    // Read
    List<OrderResponseDTO> getAllOrdersDTO();

    OrderEntity getOrderEntityById(Long orderId);
    // Create
    OrderEntity createOrder(OrderRequestDTO orderRequestDTO);

}
