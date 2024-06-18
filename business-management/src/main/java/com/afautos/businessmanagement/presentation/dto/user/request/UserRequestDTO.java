package com.afautos.businessmanagement.presentation.dto.user.request;

import java.time.LocalDate;
import java.util.Set;

public record UserRequestDTO(
        String id,
        String username,
        String password,
        String email,
        String phone,
        String name,
        String user, LocalDate birthday,
        Byte docType,
        Set<Byte> roles
)
{}
