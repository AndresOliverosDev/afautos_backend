package com.afautos.businessmanagement.services.interfaces.product;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.presentation.dto.product.request.CategoryRequestDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.CategoryResponseDTO;

public interface ICategoryService {
    
    // Read
    List<CategoryResponseDTO> getAllCategories();

    // Create
    ResponseEntity<String> createCategory(CategoryRequestDTO categoryRequestDTO);
}
