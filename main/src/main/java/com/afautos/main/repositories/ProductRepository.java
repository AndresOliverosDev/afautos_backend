package com.afautos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
