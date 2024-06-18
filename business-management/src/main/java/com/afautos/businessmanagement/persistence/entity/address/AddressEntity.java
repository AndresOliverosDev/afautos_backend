package com.afautos.businessmanagement.persistence.entity.address;

import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addr_id")
    private Integer id;

    @Column(name = "ref", length = 100, nullable = false)
    private String ref;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neighborhood")
    private NeighborhoodEntity neighborhood;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    // Override equals() and hashCode()
}
