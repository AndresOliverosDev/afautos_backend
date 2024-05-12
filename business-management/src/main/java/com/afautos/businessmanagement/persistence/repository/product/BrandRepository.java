package com.afautos.businessmanagement.persistence.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.product.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Short>{
    
}
