package com.afautos.businessmanagement.presentation.dto.user;

import java.time.LocalDate;
import java.util.Set;

public record UserAddDTO(
    String id,
    String username,
    String password,
    String email,
    String phone,
    String name,
    String surname,
    LocalDate birthday,
    Byte docType,
    Set<Byte> roles
)
{}
