package com.afautos.businessmanagement.presentation.controller.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO;
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

    // Read
    @PostMapping("/getAll")
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrdersDTO();
    }

    // Write
    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.createOrder(orderRequestDTO);
    }
}