package com.afautos.main.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afautos.main.models.user.Rol;

public interface RolRepository extends JpaRepository<Rol, Byte>{
}