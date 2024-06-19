package com.afautos.businessmanagement.presentation.controller.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    // Dependency injection
    @Autowired
    private IOrderDetailService orderDetailService;

    // Read
    @PostMapping("/getAllByOrder/{orderId}")
    public List<OrderDetailResponseDTO> getOrderDetailsByOrder(@PathVariable Long orderId) {
        return orderDetailService.getOrderDetailsByOrder(orderId);
    }
}
