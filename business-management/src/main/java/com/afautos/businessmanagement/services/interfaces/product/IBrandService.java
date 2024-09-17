package com.afautos.businessmanagement.services.interfaces.product;

import com.afautos.businessmanagement.presentation.dto.product.response.brand.BrandResponseDTO;

import java.util.List;

public interface IBrandService {
    List<BrandResponseDTO> getAllBrands();
}
