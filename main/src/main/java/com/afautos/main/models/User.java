package com.afautos.main.models;

import java.time.LocalDate;
import java.util.Set;

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

    @Column(name = "birthday")
    @Setter
    @Getter
    private LocalDate birthday;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_doc_type")
    private DocType docType;

    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "ced_user"),
        inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<Rol> roles;
}