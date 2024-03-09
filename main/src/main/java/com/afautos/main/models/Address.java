package com.afautos.main.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_addr")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "ref")
    @Getter
    @Setter
    private String ref;

    @Column(name = "neighborhood")
    @Getter
    @Setter
    private Integer neighborhood;
}

