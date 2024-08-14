package com.afautos.businessmanagement.presentation.controller.product;

import java.util.List;

import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.persistence.entity.product.CategoryEntity;
import com.afautos.businessmanagement.presentation.dto.product.request.CategoryRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.afautos.businessmanagement.presentation.dto.product.response.CategoryResponseDTO;
import com.afautos.businessmanagement.services.interfaces.product.ICategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Categorias", description = "El controlador de categorias proporciona una serie de endpoints para gestionar las categorias dentro del sistema.")
@RequestMapping("/category")
public class CategoryController {

    // Dependency injection
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Read

    @Operation(summary = "Obtener todas las categorias", description = "Recupera una lista de todas las categorias disponibles en el sistema")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllCategories")
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Create

    @Operation(summary = "Crear una categoria", description = "Crear una nueva categoria en el sistema")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createCategory")
    public CategoryEntity createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        return categoryService.createCategory(categoryRequestDTO);
    }

    // Delete

    @Operation(summary = "Eliminar una categoria", description = "Eliminar una categoria del sistema")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteCategory/{id}")
    public CategoryEntity deleteCategory(@PathVariable Byte id) throws NotFoundException {
        return categoryService.deleteCategory(id);
    }

    // Update

    @Operation(summary = "Actualizar una categoria", description = "Actualizar una categoria del sistema")
    @PreAuthorize("hasRole('ADMIN') or hasRole('LOGISTICA')")
    @PutMapping("/updateCategory/{id}")
    public CategoryEntity UpdateCategory(@PathVariable Byte id, @RequestBody CategoryRequestDTO categoryRequestDTO)
            throws NotFoundException {
        return categoryService.updateCategory(categoryRequestDTO, id);
    }
    
}
