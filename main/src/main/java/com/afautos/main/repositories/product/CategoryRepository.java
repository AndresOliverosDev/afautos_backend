package com.afautos.main.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.product.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Byte> {
    
}
