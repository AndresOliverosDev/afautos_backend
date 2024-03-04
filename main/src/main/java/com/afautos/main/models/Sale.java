package com.afautos.main.models;

@Entity
@Table(name = "sales")
public class Sale {

    @Column(name = "id_sale")
    @Id
    @GenerateValue(strategy = .IDENTIFY)
    @Getter
    @Setter
    private int idSale;

    @Column(name = "date_order")
    @Getter
    @Setter
    private Date dateOrder

    @Column(name = "pay_method")
    @Getter
    @Setter
    private String payMethod;

    @Column(name = "ced_user")
    @Getter
    @Setter
    private String customer;

    @Column(name = "id_addr")
    @Getter
    @Setter
    private int address;
}