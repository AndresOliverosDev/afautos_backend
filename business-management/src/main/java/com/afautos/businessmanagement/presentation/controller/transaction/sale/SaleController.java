package com.afautos.businessmanagement.presentation.controller.transaction.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/sale")
public class SaleController {
    
    @Autowired
    private ISaleService saleService;

    @GetMapping("/getAll")
    public List<SaleEntity> getAllSale() {
        return saleService.getAll();
    }
    

}
