package com.afautos.businessmanagement.presentation.dto.transaction.sale;

import java.math.BigDecimal;

public record SaleDetailDTO(
    Long id,
    Short quantity,
    BigDecimal priceUnit,
    BigDecimal subTotal
) {
    
}
