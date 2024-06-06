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
    @Column(name = "addr_id")
    private Integer id;

    @Column(name = "ref", length = 100)
    private String ref;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "neighborhood")
    private NeighborhoodEntity neighborhood;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    // Override equals() and hashCode()
}
