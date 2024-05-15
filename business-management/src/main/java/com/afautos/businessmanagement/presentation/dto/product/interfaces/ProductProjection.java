package com.afautos.businessmanagement.presentation.dto.product.interfaces;

import java.math.BigDecimal;

import com.afautos.businessmanagement.persistence.entity.product.BrandEntity;
import com.afautos.businessmanagement.persistence.entity.product.CategoryEntity;

public interface ProductProjection {
    Long getId();
    String getName();
    String getDesc();
    Short getQuantity();
    BigDecimal getPrice();
    String getImage();
    CategoryEntity getCategory();
    BrandEntity getBrand();
    
}
