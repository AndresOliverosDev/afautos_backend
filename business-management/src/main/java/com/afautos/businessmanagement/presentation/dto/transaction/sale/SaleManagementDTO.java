package com.afautos.businessmanagement.presentation.dto.transaction.sale;

public record SaleManagementDTO(
    SaleDTO sale,
    SaleDetailDTO saleDetail
) {}