package com.afautos.main.controllers.transaction;

import com.afautos.main.dto.transaction.sale.SaleDTO;
import com.afautos.main.repositories.transaction.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/sale")
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;

    @GetMapping("/getAll")
    List<SaleDTO> getAllSale(){
        return saleRepository.getAllSale();
    }
}
