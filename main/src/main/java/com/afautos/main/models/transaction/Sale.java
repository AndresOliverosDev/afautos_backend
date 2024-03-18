package com.afautos.main.models.transaction;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sale {

    @Column(name = "sale_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSale;

    @Column(name = "order_date")
    private Date dateOrder;

    @Column(name = "pay_method")
    private String payMethod;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "customer")
    private String customer;

    @Column(name = "address")
    private Integer address;

}