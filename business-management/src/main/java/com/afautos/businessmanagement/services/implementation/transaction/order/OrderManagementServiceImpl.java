package com.afautos.businessmanagement.services.implementation.transaction.order;

import com.afautos.businessmanagement.persistence.entity.transaction.order.OrderEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderDetailRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderManagementResponseDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleManagementDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderDetailService;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderManagementService;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderManagementServiceImpl implements IOrderManagementService {

    // Dependency injection
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    // Read
    @Override
    public List<OrderManagementResponseDTO> getAllOrderWithDetails() {
        List<OrderManagementResponseDTO> ordersManagementList = new ArrayList<>();
        // Find all orders
        List<OrderResponseDTO> ordersDTO =  orderService.getAllOrdersDTO();
        for (OrderResponseDTO orderDTO : ordersDTO) {
            List<OrderDetailResponseDTO> orderDetail = orderDetailService.getOrderDetailsByOrder(orderDTO.id());
            ordersManagementList.add(new OrderManagementResponseDTO(orderDTO, orderDetail));
        }
        return ordersManagementList;
    }

    // Create
    @Override
    public ResponseEntity<String> createOrderWithDetails(OrderRequestDTO orderRequestDTO, List<OrderDetailRequestDTO> orderDetailRequestDTO) {
        try {
            // Check if the list is empty
            if (orderDetailRequestDTO == null || orderDetailRequestDTO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El pedido debe tener los detalles");
            }
            // Create order
            OrderEntity orderEntity = orderService.createOrder(orderRequestDTO);
            if (orderEntity == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el pedido");
            }
            // Create order detail
            for (OrderDetailRequestDTO orderDetails : orderDetailRequestDTO) {
                orderDetailService.createOrderDetails(orderDetails, orderEntity.getId());
            }

            return ResponseEntity.ok("El pedido con id " + orderEntity.getId() + " se creo correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el pedido");
        }
    }

}
