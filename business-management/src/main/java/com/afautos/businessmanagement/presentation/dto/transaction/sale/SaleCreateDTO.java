package com.afautos.businessmanagement.presentation.dto.transaction.sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleCreateDTO {
    private String payMethod;
    private String customer;
    private String address;
}
