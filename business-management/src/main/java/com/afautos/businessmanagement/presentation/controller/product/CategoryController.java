package com.afautos.businessmanagement.presentation.controller.product;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}
