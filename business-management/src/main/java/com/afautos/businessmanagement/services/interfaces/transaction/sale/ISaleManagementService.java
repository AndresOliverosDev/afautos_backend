package com.afautos.businessmanagement.services.interfaces.transaction.sale;

import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleManagementDTO;

public interface ISaleManagementService {
    SaleManagementDTO getById(Long SaleId);
}
