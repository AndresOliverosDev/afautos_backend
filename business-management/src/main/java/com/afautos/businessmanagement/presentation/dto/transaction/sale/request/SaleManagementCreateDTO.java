package com.afautos.businessmanagement.presentation.dto.transaction.sale.request;

import java.util.List;

public record SaleManagementCreateDTO(
    SaleCreateDTO sale,
    List<SaleDetailCreateDTO> saleDetail
) {
    
}
