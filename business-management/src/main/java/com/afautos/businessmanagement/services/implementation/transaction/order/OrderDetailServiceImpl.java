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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    //Dependency injection
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IProductService productService;

    // Read
    @Override
    public List<OrderDetailResponseDTO> getOrderDetailsByOrder(Long orderId) {
        return orderDetailRepository.getOrderDetailsByOrder(orderId);
    }

    // Create
    @Override
    public ResponseEntity<String> createOrderDetails(OrderDetailRequestDTO orderDetailRequests, Long orderId) {
        try {
            // Find order
            OrderEntity orderEntity = orderService.getOrderEntityById(orderId);
            if (orderEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido con el id " + orderId + " no existe");
            }
            // Find product
            ProductEntity productEntity = productService.getProductEntityById(orderDetailRequests.productId());
            if (productEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto con el id " + orderDetailRequests.productId() + " no existe");
            }
            // Create order detail entity and save to database
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setQuantity(orderDetailRequests.quantity());
            orderDetailEntity.setOrder(orderEntity);
            orderDetailEntity.setProduct(productEntity);
            orderDetailRepository.save(orderDetailEntity);

            orderDetailRepository.save(orderDetailEntity);

            return ResponseEntity.ok("Los detalles del pedido con id " + orderId + " se crearon correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al crear el detalle del pedido");
        }
    }

}
