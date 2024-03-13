package com.afautos.main.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afautos.main.models.Rol;
import com.afautos.main.repositories.RolRepository;
import com.afautos.main.services.RolService;

@Service
public class RolServiceImp implements RolService{

    @Autowired
    private RolRepository rolRepository;

    @SuppressWarnings("null")
    @Override
    public Rol addRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol deleteRol(Byte id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRol'");
    }

    @Override
    public Rol updateRol(Byte id, Rol rol) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRol'");
    }

    @Override
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol getByIdRol() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByIdRol'");
    }
    
}
