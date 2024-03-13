package com.afautos.main.models;

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
public class Sale {

    @Column(name = "id_sale")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer idSale;

    @Column(name = "date_order")
    @Getter
    @Setter
    private Date dateOrder;

    @Column(name = "pay_method")
    @Getter
    @Setter
    private String payMethod;

    @Column(name = "user")
    @Getter
    @Setter
    private String customer;

    @Column(name = "address")
    @Getter
    @Setter
    private Integer address;

}