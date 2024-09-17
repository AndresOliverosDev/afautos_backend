package com.afautos.businessmanagement.persistence.repository.product;

import com.afautos.businessmanagement.presentation.dto.product.response.brand.BrandResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.product.BrandEntity;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Short>{

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.product.response.brand.BrandResponseDTO" +
            "(b.id, b.name)" +
            "FROM BrandEntity b")
    List<BrandResponseDTO> getAllBrands();

    
}
