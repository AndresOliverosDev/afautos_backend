package com.afautos.businessmanagement.persistence.entity.user;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.afautos.businessmanagement.persistence.entity.user.rol.RolEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @Column(name = "phone")
    private String phone;

    @Column(name = "names")
    private String name;

    @Column(name = "surnames")
    private String surname;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_type")
    private DocTypeEntity docType;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<RolEntity> roles = new HashSet<>();
    
}
