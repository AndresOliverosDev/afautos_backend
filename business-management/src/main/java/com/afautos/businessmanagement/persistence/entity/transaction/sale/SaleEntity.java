package com.afautos.businessmanagement.persistence.entity.transaction.sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.afautos.businessmanagement.persistence.entity.user.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long id;

    @Column(name = "sale_date")
    private LocalDateTime orderDate;

    @Column(name = "pay_method")
    private String payMethod;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer")
    private UserEntity customer;

    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "sale" )
    private List<SaleDetailEntity> saleDetail;
}
