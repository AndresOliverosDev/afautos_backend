package com.afautos.businessmanagement.services.interfaces.product;

import java.util.List;

import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.persistence.entity.product.CategoryEntity;

import com.afautos.businessmanagement.presentation.dto.product.request.CategoryRequestDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.CategoryResponseDTO;

public interface ICategoryService {
    
    // Read
    List<CategoryResponseDTO> getAllCategories();

    // Create
    CategoryEntity createCategory(CategoryRequestDTO categoryRequestDTO);

    // Delete
    CategoryEntity deleteCategory(Byte id) throws NotFoundException;
}
