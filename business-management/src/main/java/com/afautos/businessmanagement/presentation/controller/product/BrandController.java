package com.afautos.businessmanagement.presentation.controller.product;

import com.afautos.businessmanagement.presentation.dto.product.response.brand.BrandResponseDTO;
import com.afautos.businessmanagement.services.interfaces.product.IBrandService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    // Dependency injection
    private final IBrandService brandService;

    public BrandController(IBrandService brandService) {
        this.brandService = brandService;
    }

    // Get
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllBrands")
    public List<BrandResponseDTO> getAllBrands () {
        return brandService.getAllBrands();
    }
}
