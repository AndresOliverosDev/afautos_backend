package com.afautos.businessmanagement.services.implementation.product;

import java.util.List;
import java.util.Optional;

import com.afautos.businessmanagement.error.AttributeAlreadyExists;
import com.afautos.businessmanagement.error.BadRequest;
import com.afautos.businessmanagement.error.GeneralException;
import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.persistence.entity.product.CategoryEntity;
import com.afautos.businessmanagement.persistence.entity.product.ProductEntity;
import com.afautos.businessmanagement.persistence.repository.product.ProductRepository;
import com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO;
import com.afautos.businessmanagement.services.interfaces.product.IProductService;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.persistence.repository.product.CategoryRepository;
import com.afautos.businessmanagement.presentation.dto.product.request.CategoryRequestDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.CategoryResponseDTO;
import com.afautos.businessmanagement.services.interfaces.product.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

    // Dependency injection
    private final CategoryRepository categoryRepository;
    private final IProductService productService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, IProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
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
            // Search in database if exists a category with same name
            Optional<CategoryEntity> existingCategoryEntity = categoryRepository.findByName(categoryRequestDTO.name());

            if (existingCategoryEntity.isPresent()) {
                throw new AttributeAlreadyExists("Ya existe una categoría con el mismo nombre");
            } 

            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setName(categoryRequestDTO.name());
            categoryEntity.setDescription(categoryRequestDTO.description());
            return categoryRepository.save(categoryEntity);

        } catch (GeneralException e) {
            throw new GeneralException("Error al intentar crear una categoría");
        }
    }
    
    // Delete

    @Override
    public CategoryEntity deleteCategory(Byte id) throws NotFoundException {

        try {
            // Verify if the category is existing
            Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
            if (categoryEntity.isEmpty()) {
                throw new NotFoundException("La categoría con el id " + id + " no existe");
            }
            // Verify if the category not is products
            List<ProductDTO> products = productService.getAllProductsByCategory(id);
            if (!products.isEmpty()) {
                throw new BadRequest("La categoría tiene productos asociados");
            }

            categoryRepository.deleteById(id);
            return categoryEntity.get();
            
        } catch (GeneralException exception) {
            throw new GeneralException("Error interno al intentar eliminar la categoría");
        }
    }

    // Update

    @Override
    public CategoryEntity updateCategory(CategoryRequestDTO categoryRequestDTO, Byte id) throws NotFoundException {

        try {
            Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
            if (categoryEntity.isEmpty()) {
                throw new NotFoundException("Categoría con el id " + id + " no existe");
            }

            categoryEntity.get().setName(categoryRequestDTO.name());
            categoryEntity.get().setDescription(categoryRequestDTO.description());

            return categoryRepository.save(categoryEntity.get()
            );
        } catch (GeneralException exception) {
            throw new GeneralException("Error al actualizar la categoría");
        }
    }
}
