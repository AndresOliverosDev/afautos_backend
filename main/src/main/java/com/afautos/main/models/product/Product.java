package com.afautos.main.models.product;

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
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long id;

    @Column(name = "prod_name")
    private String name;

    @Column(name = "description")
    private String desc;

    @Column(name = "quantity")
    private Short quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "cat")
    private Byte cat;

    @Column(name = "brand")
    private Short brand;

}
