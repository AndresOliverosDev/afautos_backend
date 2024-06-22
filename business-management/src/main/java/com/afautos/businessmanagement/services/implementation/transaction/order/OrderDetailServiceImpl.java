package com.afautos.businessmanagement.services.implementation.transaction.order;

import com.afautos.businessmanagement.persistence.entity.transaction.order.OrderEntity;
import com.afautos.businessmanagement.persistence.repository.transaction.order.OrderDetailRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderDetailRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderDetailService;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    //Dependency injection
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private IOrderService orderService;

    // Read
    @Override
    public List<OrderDetailResponseDTO> getOrderDetailsByOrder(Long orderId) {
        return orderDetailRepository.getOrderDetailsByOrder(orderId);
    }

    // Write
    @Override
    public ResponseEntity<String> createOrderDetail(OrderDetailRequestDTO orderRequest) {
        try {
            // Find order
            Optional<OrderEntity> orderEntity = orderService.getOrderEntityById(orderRequest.orderId());
            if (orderEntity.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido con el id " + orderRequest.orderId() + " no existe");
            }

            // Find product

        }
    }

}
