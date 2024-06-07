package com.afautos.businessmanagement.presentation.dto.transaction.sale.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleManagementDTO {
    private SaleDTO sale;
    private List<SaleDetailDTO> saleDetail;
}