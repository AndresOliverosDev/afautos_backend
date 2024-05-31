package com.afautos.businessmanagement.persistence.repository.transaction.sale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleDetailEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDetailDTO;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetailEntity, Long> {

        @Query("SELECT new com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDetailDTO" +
                        "( s.product.id, s.product.image, s.product.name, s.product.brand.name" +
                        ", s.quantity, s.priceUnit, s.subtotal)" +
                        "FROM SaleDetailEntity s " +
                        "WHERE s.sale.id = :saleId")
        List<SaleDetailDTO> getAllBySale(@Param("saleId") Long saleId);
}
