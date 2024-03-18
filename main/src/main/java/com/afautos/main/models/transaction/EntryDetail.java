package com.afautos.main.models.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products_entry_details")
@Getter
@Setter
public class EntryDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_entry_id")
    private Integer id;

    @Column(name = "entry")
    private Integer entry;

    @Column(name = "product")
    private Long prod;

    @Column(name = "quantity")
    private Short quantity;
}
