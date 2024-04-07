package com.afautos.main.dto.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    
    private String id;
    private String email;
    private String phone;
    private String names;
    private String lastname;
    private LocalDate birthday;
    private String docType;
}
