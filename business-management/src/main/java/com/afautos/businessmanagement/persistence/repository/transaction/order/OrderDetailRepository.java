package com.afautos.businessmanagement.persistence.repository.transaction.order;

import com.afautos.businessmanagement.persistence.entity.transaction.order.OrderDetailEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
    // Read
    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderDetailResponseDTO" +
            "(o.id, o.quantity, o.product.id, o.product.name, o.product.brand.name, o.product.image)" +
            " FROM OrderDetailEntity o" +
            " WHERE o.order.id = :orderId")
    List<OrderDetailResponseDTO> getOrderDetailsByOrder(@Param("orderId") Long orderId);
}
