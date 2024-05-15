package com.afautos.businessmanagement.persistence.repository.transaction.sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long>{
    
}
