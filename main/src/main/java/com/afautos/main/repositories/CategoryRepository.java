package com.afautos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Short> {
    
}
