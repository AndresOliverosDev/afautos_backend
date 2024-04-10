package com.afautos.main.services.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afautos.main.models.product.Category;

@Service
public interface CategoryService {
    List<Category> getAllCat();
}
