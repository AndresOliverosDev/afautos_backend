package com.afautos.businessmanagement.persistence.entity.user;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.persistence.entity.user.rol.RolEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "username",nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "names")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "is_enable")
    private Boolean isEnable;

    @Column(name = "account_no_expired")
    private Boolean accountNoExpired;

    @Column(name = "account_no_locked")
    private Boolean accountNoLocked;

    @Column(name = "credential_no_expired")
    private Boolean credentialNoExpired;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<AddressEntity> address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type")
    private DocTypeEntity docType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<RolEntity> roles = new HashSet<>();

}