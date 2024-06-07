package com.afautos.businessmanagement.presentation.dto.user.response;

import java.time.LocalDate;
import java.util.Set;

public record UserDTO(
    String id,
    String username,
    String email,
    String phone,
    String name,
    LocalDate birthday,
    String docType,
    Set<String> roles
    )
{
}
