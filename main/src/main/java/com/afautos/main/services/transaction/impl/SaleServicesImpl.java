package com.afautos.main.services.transaction.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afautos.main.models.transaction.Sale;
import com.afautos.main.repositories.transaction.SaleRepository;
import com.afautos.main.services.transaction.SaleService;



@Service
public class SaleServicesImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }
    

}
