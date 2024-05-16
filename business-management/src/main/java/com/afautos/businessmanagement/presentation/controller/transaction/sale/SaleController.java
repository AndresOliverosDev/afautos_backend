package com.afautos.businessmanagement.presentation.controller.transaction.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/sale")
public class SaleController {
    
    @Autowired
    private ISaleService saleService;

    @GetMapping("/getAll")
    public List<SaleDTO> getAllSale() {
        return saleService.getAll();
    }
    

}
