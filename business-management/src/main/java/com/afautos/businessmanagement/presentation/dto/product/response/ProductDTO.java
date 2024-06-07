package com.afautos.businessmanagement.presentation.dto.product.response;

import java.math.BigDecimal;

public record ProductDTO(
    Long id,
    String name,
    String desc,
    Short quantity,
    BigDecimal price,
    String image,
    String category,
    String brand
) {
}
