package com.afautos.businessmanagement.presentation.controller.transaction.sale;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.request.SaleManagementCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleManagementDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleManagementService;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Ventas", description = "El controlador de ventas proporciona endpoints para gestionar las ventas dentro del sistema.")
@RestController
@RequestMapping("/sale")
public class SaleController {

    private final ISaleService saleService;
    private final ISaleManagementService saleManagementService;

    public SaleController(ISaleService saleService, ISaleManagementService saleManagementService) {
        this.saleService = saleService;
        this.saleManagementService = saleManagementService;
    }

    @Operation(summary = "Obtener todas las ventas con detalles", description = "Recupera una lista de todas las ventas disponibles en el sistema con sus detalles")
    @PreAuthorize("hasRole('ADMIN') or hasRole('VENTAS')")
    @GetMapping("/getAllSales")
    public List<SaleManagementDTO> getAllSalesDto() {
        return saleManagementService.getAllSalesDto();
    }

    @Operation(summary = "Obtener todas las ventas", description = "Recupera una lista de todas las ventas disponibles en el sistema")
    @PreAuthorize("hasRole('ADMIN') or hasRole('VENTAS')")
    @GetMapping("/getAll")
    public List<SaleDTO> getAllSale() {
        return saleService.getAll();
    }

    @Operation(summary = "Obtener venta por ID", description = "Recupera una venta específica por su ID")
    @PreAuthorize("hasRole('ADMIN') or hasRole('VENTAS')")
    @GetMapping("/getSaleById/{id}")
    public SaleManagementDTO getAllSales(@PathVariable Long id) throws LocalNotFoundException{
        return saleManagementService.getById(id);
    }

    @Operation(summary = "Crear una nueva venta", description = "Crea una nueva venta en el sistema con detalles de la venta")
    @PreAuthorize("hasAuthority('CREATE') and (hasRole('ADMIN') or hasRole('VENTAS'))")
    @PostMapping("/createSale")
    public ResponseEntity<String> createSale(@RequestBody SaleManagementCreateDTO saleManagement) {
        return saleManagementService.createSaleWithSaleDetail(saleManagement.sale(), saleManagement.saleDetail());
    }

    @Operation(summary = "Obtener venta por ID", description = "Recupera una venta específica por su ID")
    @PreAuthorize("hasRole('ADMIN') or hasRole('VENTAS')")
    @GetMapping("/getById/{id}")
    public SaleDTO getSaleDTOById(@PathVariable Long id) throws LocalNotFoundException {
        return saleService.getSaleDTOById(id);
    }

}