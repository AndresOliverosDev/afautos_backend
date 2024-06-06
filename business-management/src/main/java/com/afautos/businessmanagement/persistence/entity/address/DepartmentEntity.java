package com.afautos.businessmanagement.persistence.entity.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depart_id")
    private Byte id;

    @Column(name = "depart_name", length = 60, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "department",
            orphanRemoval = true)
    private List<CityEntity> cities = new ArrayList<>();
}
