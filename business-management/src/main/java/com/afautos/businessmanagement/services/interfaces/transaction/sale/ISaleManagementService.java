package com.afautos.businessmanagement.services.interfaces.transaction.sale;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.request.SaleCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.request.SaleDetailCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleManagementDTO;

import jakarta.transaction.Transactional;

public interface ISaleManagementService {

    List<SaleManagementDTO> getAllSalesDto();

    SaleManagementDTO getById(Long SaleId) throws LocalNotFoundException;

    @Transactional
    ResponseEntity<String> createSaleWithSaleDetail(SaleCreateDTO saleCreateDTO,
            List<SaleDetailCreateDTO> saleDetailCreateDTO);
}
