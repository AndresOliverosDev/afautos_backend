package com.afautos.main.dto.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String desc;
    private Short quantity;
    private BigDecimal price;
    private String imageUrl;
    private String cat;
    private String brand;
}
