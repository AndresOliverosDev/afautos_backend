package com.afautos.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.main.models.Rol;
import com.afautos.main.services.RolService;

@RestController
public class RolController {

    @Autowired
    RolService rolService;
    
    @PostMapping("/addRol")
    public Rol addRol(@RequestBody Rol rol){
        return rolService.addRol(rol);
    }

    @PostMapping("/getAlRoles")
    public List<Rol> getAllRoles(){
        return rolService.getAllRoles();
    }
}