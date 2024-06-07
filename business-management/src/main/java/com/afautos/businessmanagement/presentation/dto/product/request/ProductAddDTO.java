package com.afautos.businessmanagement.presentation.dto.product.request;

import java.math.BigDecimal;

public record ProductAddDTO(
    String name,
    String desc,
    Short quantity,
    BigDecimal price,
    String image,
    Byte category,
    Short brand
) {
    
}
