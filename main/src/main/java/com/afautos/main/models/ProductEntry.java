package com.afautos.main.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products_entry")
@Getter
@Setter
public class ProductEntry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private Integer id;

    @Column(name = "entry_date")
    private LocalDateTime date;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "observations")
    private String observation;
}
