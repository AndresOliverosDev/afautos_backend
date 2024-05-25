package com.afautos.businessmanagement.services.interfaces.transaction.sale;

import java.util.List;
import java.util.Optional;

import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;

public interface ISaleService {
    List<SaleDTO> getAll();

    Optional<SaleDTO> getById(Long id);
}
