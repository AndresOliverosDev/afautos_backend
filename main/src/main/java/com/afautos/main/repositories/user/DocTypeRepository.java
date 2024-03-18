package com.afautos.main.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afautos.main.models.user.DocType;

public interface DocTypeRepository extends JpaRepository<DocType, Byte>{
    
}
