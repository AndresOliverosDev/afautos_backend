package com.afautos.businessmanagement.services.interfaces.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderDetailRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderDetailService {
    // Read
    List<OrderDetailResponseDTO> getOrderDetailsByOrder(Long orderId);

    // Write
    ResponseEntity<String> createOrderDetail(OrderDetailRequestDTO orderDetailRequestDTO);
}
