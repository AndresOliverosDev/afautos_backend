package com.afautos.main.services.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afautos.main.models.product.Category;
import com.afautos.main.repositories.product.CategoryRepository;
import com.afautos.main.services.product.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCat() {
        return categoryRepository.findAll();
    }

}
