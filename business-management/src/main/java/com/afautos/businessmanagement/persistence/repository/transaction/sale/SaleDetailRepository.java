package com.afautos.businessmanagement.persistence.repository.transaction.sale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleDetailEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDetailDTO;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetailEntity, Long>{
    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDetailDTO" +
        "(s.id, s.quantity, s.priceUnit, s.subtotal) FROM SaleDetailEntity s"
    )
    List<SaleDetailDTO> getAll();
}  
