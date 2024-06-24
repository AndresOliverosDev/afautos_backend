package com.afautos.businessmanagement.presentation.controller.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderManagementResponseDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderManagementService;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedidos", description = "El controlador de pedidos proporciona endpoints para gestionar pedidos dentro del sistema.")
@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService;
    private final IOrderManagementService orderManagementService;

    public OrderController(IOrderService orderService, IOrderManagementService orderManagementService) {
        this.orderService = orderService;
        this.orderManagementService = orderManagementService;
    }

    @Operation(summary = "Obtener todos los pedidos", description = "Recupera una lista de todos los pedidos disponibles en el sistema")
    @PreAuthorize("hasAuthority('READ') and (hasRole('ADMIN') or hasRole('LOGISTICA'))")
    @GetMapping("/getAll")
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrdersDTO();
    }

    @Operation(summary = "Obtener todos los pedidos con detalles", description = "Recupera una lista de todos los pedidos con sus detalles en el sistema")
    @PreAuthorize("hasAuthority('READ') and (hasRole('ADMIN') or hasRole('LOGISTICA'))")
    @GetMapping("/getAllWithDetails")
    public List<OrderManagementResponseDTO> getAllOrdersWithDetails() {
        return orderManagementService.getAllOrdersWithDetails();
    }

    @Operation(summary = "Crear un nuevo pedido", description = "Crea un nuevo pedido en el sistema")
    @PreAuthorize("hasAuthority('CREATE') and (hasRole('ADMIN') or hasRole('LOGISTICA'))")
    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.createOrder(orderRequestDTO);
    }
}