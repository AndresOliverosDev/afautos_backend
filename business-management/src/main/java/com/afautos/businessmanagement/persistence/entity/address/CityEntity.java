package com.afautos.businessmanagement.persistence.entity.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Short id;

    @Column(name = "city_name", length = 60, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depart")
    private DepartmentEntity department;

    @OneToMany(cascade = CascadeType.ALL,
                mappedBy = "city",
                orphanRemoval = true)
    private List<NeighborhoodEntity> neighborhoods = new ArrayList<>();


}
