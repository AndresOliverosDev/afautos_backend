package com.afautos.main.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.product.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Short>{
    
}
