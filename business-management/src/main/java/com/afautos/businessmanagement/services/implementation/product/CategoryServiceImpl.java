package com.afautos.businessmanagement.services.implementation.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.persistence.repository.product.CategoryRepository;
import com.afautos.businessmanagement.presentation.dto.product.request.CategoryRequestDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.CategoryResponseDTO;
import com.afautos.businessmanagement.services.interfaces.product.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

    // Dependency injection

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Read

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    // Create

    @Override
    public ResponseEntity<String> createCategory(CategoryRequestDTO categoryRequestDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'createCategory'");
    }
    
}
