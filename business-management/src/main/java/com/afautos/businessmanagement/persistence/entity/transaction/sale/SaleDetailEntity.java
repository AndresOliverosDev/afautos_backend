package com.afautos.businessmanagement.persistence.entity.transaction.sale;

import java.math.BigDecimal;

import com.afautos.businessmanagement.persistence.entity.product.ProductEntity;
import com.afautos.businessmanagement.presentation.dto.product.interfaces.ProductProjection;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sale_details")
@Getter
@Setter
public class SaleDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_detail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product")
    private ProductProjection product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale")
    @JsonBackReference
    private SaleEntity sale;

    private Short quantity;
    
    private BigDecimal priceUnit;

    private BigDecimal subtotal;

}
