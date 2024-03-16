package com.afautos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Short>{
    
}
