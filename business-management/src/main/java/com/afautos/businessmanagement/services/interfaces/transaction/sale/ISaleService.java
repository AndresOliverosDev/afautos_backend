package com.afautos.businessmanagement.services.interfaces.transaction.sale;

import java.math.BigDecimal;
import java.util.List;

import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.request.SaleCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDTO;
import org.springframework.http.ResponseEntity;

public interface ISaleService {

    // Read

    ResponseEntity<?> getSalesByCustomer(String customer);

    List<SaleDTO> getAll();

    SaleDTO getSaleDTOById(Long id) throws NotFoundException;

    SaleEntity getSaleEntityById(Long id);

    SaleEntity createSale(SaleCreateDTO saleCreateDTO) throws NotFoundException;

    void updateTotalPrice(BigDecimal totalPrice, Long saleId);
}
