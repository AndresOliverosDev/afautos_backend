package com.afautos.main.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "users")
public class User {

    @Column(name = "ced_user", nullable = false)
    @Id
    @Getter
    @Setter
    private String ced;

    @Column(name = "pass")
    @Getter
    @Setter
    private String password;

    @Column(name = "email")
    @Setter
    @Getter
    private String email;

    @Column(name = "phone")
    @Setter
    @Getter
    private String phone;

    @Column(name = "names")
    @Setter
    @Getter
    private String names;

    @Column(name = "lastname")
    @Setter
    @Getter
    private String lastname;

    @Column(name = "doc_type")
    @Setter
    @Getter
    private String docType;

    @Column(name = "birthday")
    @Setter
    @Getter
    private LocalDate birthday;

    @ManyToMany
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "ced_user"),
        inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<Rol> roles;
}