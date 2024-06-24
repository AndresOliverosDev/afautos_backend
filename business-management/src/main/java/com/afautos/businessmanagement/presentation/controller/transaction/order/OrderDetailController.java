package com.afautos.businessmanagement.presentation.controller.transaction.order;

import com.afautos.businessmanagement.presentation.dto.transaction.order.request.OrderDetailRequestDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.order.IOrderDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Detalles de Pedido", description = "El controlador de detalles de pedido proporciona endpoints para gestionar los detalles de los pedidos dentro del sistema.")
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    private final IOrderDetailService orderDetailService;

    public OrderDetailController(IOrderDetailService orderDetailService){
        this.orderDetailService = orderDetailService;
    }

    @Operation(summary = "Obtener detalles de pedido por ID de pedido", description = "Recupera una lista de todos los detalles de un pedido específico por el ID del pedido")
    @GetMapping("/getAllByOrder/{orderId}")
    public List<OrderDetailResponseDTO> getOrderDetailsByOrder(@PathVariable Long orderId) {
        return orderDetailService.getOrderDetailsByOrder(orderId);
    }

    @Operation(summary = "Crear un nuevo detalle de pedido", description = "Crea un nuevo detalle de pedido en el sistema")
    @PreAuthorize("hasAuthority('CREATE') and (hasRole('ADMIN') or hasRole('LOGISTICA))")
    @PostMapping("/createOrderDetail")
    public ResponseEntity<String> createOrderDetail(@RequestBody OrderDetailRequestDTO orderDetailRequestDTO) {
        return orderDetailService.createOrderDetail(orderDetailRequestDTO);
    }
}
