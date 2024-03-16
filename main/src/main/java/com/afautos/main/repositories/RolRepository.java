package com.afautos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afautos.main.models.Rol;

public interface RolRepository extends JpaRepository<Rol, Byte>{
}