package com.afautos.businessmanagement.persistence.repository.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.product.CategoryEntity;
import com.afautos.businessmanagement.presentation.dto.product.response.CategoryResponseDTO;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Byte>{

    // Read
    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.product.response.CategoryResponseDTO" +
        "(c.id, c.name, c.description)" +
        "FROM CategoryEntity c"
    )
    List<CategoryResponseDTO> getAllCategories();

    Optional<CategoryEntity> findByName(String name);
    
}
