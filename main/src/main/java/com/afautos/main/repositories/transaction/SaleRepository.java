package com.afautos.main.repositories.transaction;

import com.afautos.main.dto.transaction.sale.SaleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.transaction.Sale;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>{
    @Query("SELECT new com.afautos.main.dto.transaction.sale.SaleDTO(s.id,s.date,s.payMethod,s.totalPrice,s.address,s.customer.names, s.products.name) FROM Sale s")
    List<SaleDTO> getAllSale();
}
