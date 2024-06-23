package com.afautos.businessmanagement.services.implementation.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderManagementResponseDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderDetailService;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderManagementService;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderManagementServiceImpl implements IOrderManagementService {
    // Constructor Dependency injection
    private final IOrderService orderService;
    private final IOrderDetailService orderDetailService;

    public OrderManagementServiceImpl(IOrderService orderService, IOrderDetailService orderDetailService) {
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
    }

    // Read
    @Override
    public List<OrderManagementResponseDTO> getAllOrdersWithDetails() {

            List<OrderManagementResponseDTO> orderManagementDTOList = new ArrayList<>();

            List<OrderResponseDTO> ordersListDTO = orderService.getAllOrdersDTO();

            for (OrderResponseDTO orderResponseDTO : ordersListDTO) {
                List<OrderDetailResponseDTO> orderDetailDTOList = orderDetailService.getOrderDetailsByOrder(orderResponseDTO.id());
                orderManagementDTOList.add(new OrderManagementResponseDTO(orderResponseDTO, orderDetailDTOList));
            }

            return orderManagementDTOList;
    }
}
