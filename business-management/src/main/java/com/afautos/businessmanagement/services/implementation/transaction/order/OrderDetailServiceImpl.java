package com.afautos.businessmanagement.services.implementation.transaction.order;

import com.afautos.businessmanagement.persistence.repository.transaction.order.OrderDetailRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    //Dependency injection
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    // Read
    @Override
    public List<OrderDetailResponseDTO> getOrderDetailsByOrder(Long orderId) {
        return orderDetailRepository.getOrderDetailsByOrder(orderId);
    }
}
