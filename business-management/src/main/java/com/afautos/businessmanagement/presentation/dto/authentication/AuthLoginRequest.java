package com.afautos.businessmanagement.presentation.dto.authentication;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(
    @NotBlank String username,
    @NotBlank String password
) 
{}
