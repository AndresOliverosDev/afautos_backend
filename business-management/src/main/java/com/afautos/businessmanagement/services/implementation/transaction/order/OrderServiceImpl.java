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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    // Read Entities Methods
    @Override
    public Optional<OrderEntity> getOrderEntityById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    // Write Methods
    @Override
    public ResponseEntity<String> createOrder(OrderRequestDTO orderRequestDTO) {
        try {
            // Search the sale
            SaleEntity saleEntity = saleService.getSaleEntityById(orderRequestDTO.saleId());
            if (saleEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El pedido con el id "
                        + orderRequestDTO.saleId() + " no existe");
            }

            // Search the employee
            UserEntity employeeEntity = userService.getUserEntityById(orderRequestDTO.employeeId());
            if (employeeEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El empleado con el id "
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
            orderRepository.save(orderEntity);

            return ResponseEntity.ok("El pedido se creo correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el pedido: ");
        }
    }
}
