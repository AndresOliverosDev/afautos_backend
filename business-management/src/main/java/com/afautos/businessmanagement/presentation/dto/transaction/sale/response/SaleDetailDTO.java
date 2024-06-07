package com.afautos.businessmanagement.presentation.dto.transaction.sale.response;

import java.math.BigDecimal;

public record SaleDetailDTO(
    Long productId,
    String productImage,
    String productName,
    String productBrand,
    Short quantity,
    BigDecimal priceUnit,
    BigDecimal subTotal
) {}
