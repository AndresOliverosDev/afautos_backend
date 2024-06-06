package com.afautos.businessmanagement.presentation.dto.transaction.sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SaleDTO(
    Long id,
    LocalDateTime saleDate,
    String payMethod,
    BigDecimal totalPrice,
    String address,
    String customer
) {}
