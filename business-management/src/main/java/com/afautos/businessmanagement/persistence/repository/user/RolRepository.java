package com.afautos.businessmanagement.persistence.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.user.rol.RolEntity;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Byte>{
    
}
