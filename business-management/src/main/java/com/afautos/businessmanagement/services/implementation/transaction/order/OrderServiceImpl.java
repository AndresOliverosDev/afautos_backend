package com.afautos.businessmanagement.services.implementation.transaction.order;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.transaction.order.OrderEntity;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.persistence.repository.transaction.order.OrderRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderService;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    // Dependency Injection
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ISaleService saleService;

    @Autowired
    private IUserService userService;

    // Read Methods
    @Override
    public List<OrderResponseDTO> getAllOrdersDTO() {
        return orderRepository.getAllOrders();
    }

    @Override
    public OrderEntity getOrderEntityById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    // Write Methods
    @Override
    public OrderEntity createOrder(OrderRequestDTO orderRequestDTO) {
        try {
            // Search the sale
            SaleEntity saleEntity = saleService.getSaleEntityById(orderRequestDTO.saleId());
            if (saleEntity == null) {
                throw new LocalNotFoundException("El pedido con el id "
                        + orderRequestDTO.saleId() + " no existe");
            }

            // Search the employee
            UserEntity employeeEntity = userService.getUserEntityById(orderRequestDTO.employeeId());
            if (employeeEntity == null) {
                throw new LocalNotFoundException("El empleado con el id "
                        + orderRequestDTO.employeeId() + " no existe");
            }

            // catch date
            LocalDateTime dateCurrent = LocalDateTime.now();

            // Create order entity
            OrderEntity orderEntity = new OrderEntity();

            orderEntity.setDate(dateCurrent);
            orderEntity.setState(orderRequestDTO.state());
            orderEntity.setObservations(orderRequestDTO.observations());
            orderEntity.setSale(saleEntity);
            orderEntity.setEmployee(employeeEntity);

            // Save to database
            return orderRepository.save(orderEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el pedido: ");
        }
    }
}
