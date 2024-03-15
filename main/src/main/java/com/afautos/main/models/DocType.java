package com.afautos.main.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "document_type")
@Getter
public class DocType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doc_type")
    private Byte id;

    @Column(name = "name_doc_type")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docType", cascade = CascadeType.ALL)
    private List<User> user;
}
