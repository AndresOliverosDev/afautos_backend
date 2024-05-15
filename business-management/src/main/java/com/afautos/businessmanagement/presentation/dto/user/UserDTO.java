package com.afautos.businessmanagement.presentation.dto.user;

import java.time.LocalDate;

public record UserDTO(
    String id,
    String username,
    String email,
    String phone,
    String name,
    String surname,
    LocalDate birthday,
    String docType,
    String roles
    )
{
}
