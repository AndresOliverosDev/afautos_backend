package com.afautos.businessmanagement.persistence.repository.transaction.order;

import com.afautos.businessmanagement.persistence.entity.transaction.order.OrderEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.transaction.order.response.OrderResponseDTO(" +
            "o.id, o.date, o.state, o.observations, o.sale.id, o.employee.name)" +
            " FROM OrderEntity o")
    List<OrderResponseDTO> getAllOrders();

}
