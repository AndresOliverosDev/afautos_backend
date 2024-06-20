package com.afautos.businessmanagement.presentation.controller.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderManagementRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderManagementResponseDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderManagementService;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    //Dependency injection
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderManagementService orderManagementService;

    // Read
    @GetMapping("/getAllOrders")
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrdersDTO();
    }

    @GetMapping("/getAllOrdersWithDetails")
    public List<OrderManagementResponseDTO> getAllOrdersWithDetails() {
        return orderManagementService.getAllOrderWithDetails();
    }

    // Write
    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody OrderManagementRequestDTO orderDTO) {
        return orderManagementService.createOrderWithDetails(orderDTO.order(), orderDTO.orderDetails());
    }


}
