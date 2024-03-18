package com.afautos.main.repositories.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.transaction.ProductEntry;

@Repository
public interface ProductEntryRepository extends JpaRepository<ProductEntry, Integer>{
    
}
