package com.afautos.main.models.transaction;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sale_details")
@Getter
@Setter
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_detail_id")
    private Long id;

    @Column(name = "product")
    private Long prod;

    @Column(name = "sale")
    private Integer sale;

    @Column(name = "quantity")
    private Short quantity;

    @Column(name = "price_unit")
    private BigDecimal priceUnit;

    @Column(name = "subtotal")
    private BigDecimal subtotal;
}