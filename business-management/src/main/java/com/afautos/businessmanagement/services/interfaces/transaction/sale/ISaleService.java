package com.afautos.businessmanagement.services.interfaces.transaction.sale;

import java.math.BigDecimal;
import java.util.List;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.request.SaleCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDTO;

public interface ISaleService {
    List<SaleDTO> getAll();

    SaleDTO getSaleDTOById(Long id) throws LocalNotFoundException;

    SaleEntity getSaleEntityById(Long id) throws LocalNotFoundException;

    SaleEntity createSale(SaleCreateDTO saleCreateDTO) throws LocalNotFoundException;

    void updateTotalPrice(BigDecimal totalPrice, Long saleId);
}
