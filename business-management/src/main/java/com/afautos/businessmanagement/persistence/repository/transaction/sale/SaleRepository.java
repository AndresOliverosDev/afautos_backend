package com.afautos.businessmanagement.persistence.repository.transaction.sale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDTO;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long>{

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDTO" +
            "(s.id, s.saleDate, s.payMethod, s.totalPrice, s.address, s.customer.name)" +
            "FROM SaleEntity s " +
            "WHERE s.customer.id = :customerId"
    )
    List<SaleDTO> getSalesByCustomer(@Param("customerId") String customerId);

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDTO" +
    "(s.id, s.saleDate, s.payMethod, s.totalPrice, s.address, s.customer.name) FROM SaleEntity s"
    )
    List<SaleDTO> getAll();

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDTO" +
    "(s.id, s.saleDate, s.payMethod, s.totalPrice, s.address, s.customer.name) FROM SaleEntity s WHERE s.id = :id"
    )
    SaleDTO getSaleById(@Param("id") Long id);
    
}
