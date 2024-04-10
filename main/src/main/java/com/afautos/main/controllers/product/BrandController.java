package com.afautos.main.controllers.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.main.models.product.Brand;
import com.afautos.main.services.BrandService;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/getAllBrand")
    public List<Brand> getAllBrand() {
        return brandService.getAllBrand();
    }
}
