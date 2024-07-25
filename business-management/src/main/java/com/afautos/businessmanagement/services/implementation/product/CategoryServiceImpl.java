package com.afautos.businessmanagement.services.implementation.product;

import java.util.List;
import java.util.Optional;

import com.afautos.businessmanagement.persistence.entity.product.CategoryEntity;
import org.springframework.http.HttpStatus;
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
    public CategoryEntity createCategory(CategoryRequestDTO categoryRequestDTO) {
        try {

            Optional<CategoryEntity> existingCategoryEntity = categoryRepository.findByName(categoryRequestDTO.name());

            if (existingCategoryEntity.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre de la categoría ya existe");
            }

            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setName(categoryRequestDTO.name());
            categoryEntity.setDesc(categoryRequestDTO.description());
            categoryRepository.save(categoryEntity);


            return ResponseEntity.ok("La categoría se creo correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la categoría");
        }
    }
    
}
