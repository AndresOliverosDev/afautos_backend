package com.afautos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.ProductEntry;

@Repository
public interface ProductEntryRepository extends JpaRepository<ProductEntry, Integer>{
    
}
