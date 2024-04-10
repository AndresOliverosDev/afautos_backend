package com.afautos.main.controllers.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.main.models.product.Category;
import com.afautos.main.services.product.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCat")
    public List<Category> getAllCat() {
        return categoryService.getAllCat();
    }
}
