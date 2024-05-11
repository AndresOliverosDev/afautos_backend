package com.afautos.main.models.transaction;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.afautos.main.models.product.Product;
import com.afautos.main.models.user.User;
import jakarta.persistence.*;
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
    private Date date;

    @Column(name = "pay_method")
    private String payMethod;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "address")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer")
    private User customer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "sale_details",
            joinColumns = @JoinColumn(name = "sale_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "product")
    )
    private List<Product> products = new ArrayList<>();
}