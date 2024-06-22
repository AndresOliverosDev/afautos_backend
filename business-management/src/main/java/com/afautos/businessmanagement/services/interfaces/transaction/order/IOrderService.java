package com.afautos.businessmanagement.services.interfaces.transaction.order;

import com.afautos.businessmanagement.persistence.entity.transaction.order.OrderEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<OrderResponseDTO> getAllOrdersDTO();

    // Read Entities
    Optional<OrderEntity> getOrderEntityById(Long id);

    ResponseEntity<String> createOrder(OrderRequestDTO orderRequestDTO);
}
