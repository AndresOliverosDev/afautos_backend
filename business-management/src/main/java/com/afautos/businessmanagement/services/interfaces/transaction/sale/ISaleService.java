package com.afautos.businessmanagement.services.interfaces.transaction.sale;

import java.util.List;

import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;

public interface ISaleService {
    List<SaleDTO> getAll();
}
