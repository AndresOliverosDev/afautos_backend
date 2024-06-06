package com.afautos.businessmanagement.persistence.entity.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "neighborhoods")
@Getter
@Setter
public class NeighborhoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "neighborhood_id")
    private Integer id;

    @Column(name = "neighborhood_name", length = 60, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city")
    private CityEntity city;
}
