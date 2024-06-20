package com.afautos.businessmanagement.presentation.controller.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderDetailRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    // Dependency injection
    @Autowired
    private IOrderDetailService orderDetailService;

    // Read
    @GetMapping("/getAllByOrder/{orderId}")
    public List<OrderDetailResponseDTO> getOrderDetailsByOrder(@PathVariable Long orderId) {
        return orderDetailService.getOrderDetailsByOrder(orderId);
    }

    // Create
    @PostMapping("create/{orderId}")
    public ResponseEntity<String> createOrderDetails(@RequestBody OrderDetailRequestDTO orderDetailRequestDTO, @PathVariable Long orderId) {
        return orderDetailService.createOrderDetails(orderDetailRequestDTO, orderId);
    }

}
