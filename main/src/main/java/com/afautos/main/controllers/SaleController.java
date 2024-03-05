package com.afautos.main.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.main.models.Sale;
import com.afautos.main.services.SaleService;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/getAllSales")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }
}
