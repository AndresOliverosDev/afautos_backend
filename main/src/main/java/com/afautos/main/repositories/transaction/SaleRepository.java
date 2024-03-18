package com.afautos.main.repositories.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.transaction.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>{
    
}
