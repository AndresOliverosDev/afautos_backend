package com.afautos.main.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "users")
public class User {

    @Column(name = "ced_user")
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

    @Column(name = "rol")
    @Setter
    @Getter
    private String rol;

    @Column(name = "doc_type")
    @Setter
    @Getter
    private String docType;

    @Column(name = "birthday")
    @Setter
    @Getter
    private Date birthday;
}