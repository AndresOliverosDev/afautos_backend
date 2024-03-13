package com.afautos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afautos.main.models.DocType;

public interface DocTypeRepository extends JpaRepository<DocType, Byte>{
    
}
