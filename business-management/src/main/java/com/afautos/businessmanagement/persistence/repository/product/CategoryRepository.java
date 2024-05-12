package com.afautos.businessmanagement.persistence.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.product.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Byte>{
    
}
