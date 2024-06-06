package com.afautos.businessmanagement.persistence.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressEntity {
    private Integer id;

    private String ref;

    private Integer neighborhood;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

    // Override equals() and hashCode()

    @Override
    public boolean equals(Object obj) {
        return
    }
}
