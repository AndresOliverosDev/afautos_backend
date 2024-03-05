package com.afautos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>{
    
}
