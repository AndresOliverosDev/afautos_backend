package com.afautos.businessmanagement.services.implementation.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import com.afautos.businessmanagement.services.interfaces.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.afautos.businessmanagement.presentation.dto.user.request.UserAddDTO;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;

@Component
public class UserEventListener {

    @Autowired
    private IUserService userService;

    @EventListener
    public void onApplicationStarted(ApplicationStartedEvent event) {
        Set<Byte> roles = Set.of((byte) 1); // Aquí deberías proporcionar el ID del rol deseado
        UserAddDTO newUser = new UserAddDTO(
                "1",
                "admin",
                "admin",
                "admin@example.com",
                "123456789",
                "Admin",
                "User",
                LocalDate.of(1990, 1, 1),
                (byte) 1, // Aquí deberías proporcionar el ID correcto del tipo de documento
                roles // Asigna el conjunto de roles al usuario
        );

        // Agregar el nuevo usuario utilizando el servicio IUserService
        userService.addUser(newUser);
    }
}
