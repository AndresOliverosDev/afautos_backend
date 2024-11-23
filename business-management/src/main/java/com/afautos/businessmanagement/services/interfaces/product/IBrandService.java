package com.afautos.businessmanagement.services.interfaces.product;

import com.afautos.businessmanagement.persistence.entity.product.BrandEntity;
import com.afautos.businessmanagement.presentation.dto.product.request.BrandRequestDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.brand.BrandResponseDTO;

import java.util.List;

public interface IBrandService {
    List<BrandResponseDTO> getAllBrands();
    // Crear una nueva marca
    BrandEntity createBrand(BrandRequestDTO brand);
    // Eliminar una marca
    BrandEntity deleteBrand(Short id);
    // Actualizar una marca
    BrandEntity updateBrand(BrandRequestDTO brand, Short brandID);
}
