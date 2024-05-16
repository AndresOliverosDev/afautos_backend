package com.afautos.businessmanagement.persistence.repository.transaction.sale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long>{

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO" +
    "(s.id, s.saleDate, s.payMethod, s.totalPrice, s.address) FROM SaleEntity s"
    )
    List<SaleDTO> getAll();
    
}
