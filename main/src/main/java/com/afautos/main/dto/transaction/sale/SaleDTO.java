package com.afautos.main.dto.transaction.sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;

public record SaleDTO(
        Integer id,
        LocalDateTime date,
        String payMethod,
        BigDecimal totalPrice,
        String address,
        String customerName,
        List<String> products
) {
}
