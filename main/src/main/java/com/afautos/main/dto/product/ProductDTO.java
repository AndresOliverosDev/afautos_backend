package com.afautos.main.dto.product;

import java.math.BigDecimal;

public record ProductDTO(
    Long id,
    String name,
    String desc,
    Short quantity,
    BigDecimal price,
    String imageUrl,
    String cat,
    String brand
) {
}