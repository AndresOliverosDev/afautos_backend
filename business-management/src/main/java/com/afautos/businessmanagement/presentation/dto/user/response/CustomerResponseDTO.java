package com.afautos.businessmanagement.presentation.dto.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CustomerResponseDTO {
        private String id;
        private String name;
        private String phone;
        private String email;
        private LocalDate birthday;
        private String docType;
}
