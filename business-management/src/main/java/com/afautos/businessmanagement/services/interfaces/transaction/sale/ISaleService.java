package com.afautos.businessmanagement.services.interfaces.transaction.sale;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;

public interface ISaleService {
    List<SaleDTO> getAll();

    SaleDTO getSaleDTOById(Long id) throws LocalNotFoundException;

    SaleEntity getSaleEntityById(Long id) throws LocalNotFoundException;

    SaleEntity createSale(SaleCreateDTO saleCreateDTO) throws LocalNotFoundException;

    ResponseEntity<String> updateTotalPrice(BigDecimal totalPrice, Long saleId);
}
