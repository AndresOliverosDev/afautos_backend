package com.afautos.businessmanagement.services.implementation.transaction.order;

import com.afautos.businessmanagement.persistence.entity.product.ProductEntity;
import com.afautos.businessmanagement.persistence.entity.transaction.order.OrderDetailEntity;
import com.afautos.businessmanagement.persistence.entity.transaction.order.OrderEntity;
import com.afautos.businessmanagement.persistence.repository.transaction.order.OrderDetailRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderDetailRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import com.afautos.businessmanagement.services.interfaces.product.IProductService;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderDetailService;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    //Dependency injection
    private final OrderDetailRepository orderDetailRepository;
    private final IOrderService orderService;
    private final IProductService productService;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, IOrderService orderService, IProductService productService) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderService = orderService;
        this.productService = productService;
    }

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
            Optional<ProductEntity> productEntity = productService.getProductEntityById(orderRequest.productId());
            if (productEntity.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto con id " + orderRequest.productId() + " no existe");
            }

            // Save order detail to database
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setProduct(productEntity.get());
            orderDetailEntity.setOrder(orderEntity.get());
            orderDetailEntity.setQuantity(orderRequest.quantity());
            orderDetailRepository.save(orderDetailEntity);

            return ResponseEntity.ok("El detalle del pedido se agrego correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el detalle del pedido");
        }
    }

}
