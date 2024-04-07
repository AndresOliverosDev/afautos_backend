package com.afautos.main.models.user;

import java.util.List;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "pass", nullable = false)
    private String pass;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "names", nullable = false)
    private String names;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthday")
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "doc_type")
    private DocType docType;

    @OneToMany
    @JoinColumn(name = "user")
    private List<Address> address;
}