package com.afautos.main.services;

import java.util.List;

import com.afautos.main.models.Rol;

public interface RolService {

    Rol addRol(Rol rol);

    Rol deleteRol(Byte id);

    Rol updateRol(Byte id, Rol rol);

    List<Rol> getAllRoles();

    Rol getByIdRol();
}
