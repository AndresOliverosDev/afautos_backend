package com.afautos.businessmanagement.presentation.controller.product;

import com.afautos.businessmanagement.persistence.entity.product.BrandEntity;
import com.afautos.businessmanagement.presentation.dto.product.request.BrandRequestDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.brand.BrandResponseDTO;
import com.afautos.businessmanagement.services.interfaces.product.IBrandService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    // Dependency injection
    private final IBrandService brandService;

    public BrandController(IBrandService brandService) {
        this.brandService = brandService;
    }

    // Obtener todas las marcas
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/getAllBrands")
    public List<BrandResponseDTO> getAllBrands () {
        return brandService.getAllBrands();
    }

    // Crear una nueva marca
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createBrand")
    public BrandEntity createBrand(@RequestBody BrandRequestDTO brand) {
        return brandService.createBrand(brand);
    }

    // Eliminar una marca
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteBrand/{brandID}")
    public BrandEntity deleteBrand(@PathVariable Short brandID) {
        return brandService.deleteBrand(brandID);
    }

    // Actualizar una marca
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateBrand/{brandID}")
    public BrandEntity updateBrand(@RequestBody BrandRequestDTO brand ,@PathVariable Short brandID) {
        return brandService.updateBrand(brand, brandID);
    }

}
