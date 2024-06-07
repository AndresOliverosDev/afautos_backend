package com.afautos.businessmanagement.presentation.controller.transaction.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.repository.transaction.sale.SaleDetailRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDetailDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.request.SaleManagementCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleManagementDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleDetailService;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleManagementService;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    SaleDetailRepository saleDetailRepository;
    
    @Autowired
    private ISaleService saleService;

    @Autowired
    private ISaleManagementService saleManagementService;

    @Autowired
    private ISaleDetailService saleDetailService;

    @GetMapping("/getAllSales")
    public List<SaleManagementDTO> getAllSalesDto() {
        return saleManagementService.getAllSalesDto();
    }

    @GetMapping("/getAll")
    public List<SaleDTO> getAllSale() {
        return saleService.getAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/getSaleById/{id}")
    public SaleManagementDTO getAllSales(@PathVariable Long id) throws LocalNotFoundException{
        return saleManagementService.getById(id);
    }

    @PostMapping("/createSale")
    public ResponseEntity<String> createSale(@RequestBody SaleManagementCreateDTO saleManagement) {
        return saleManagementService.createSaleWithSaleDetail(saleManagement.sale(), saleManagement.saleDetail());
    }

    @GetMapping("/getById/{id}")
    public SaleDTO getSaleDTOById(@PathVariable Long id) throws LocalNotFoundException {
        return saleService.getSaleDTOById(id);
    }

    @GetMapping("/test/{id}")
    public List<SaleDetailDTO> getMethodName(@PathVariable Long id) {
        return saleDetailRepository.getAllBySale(id);
    }

}
