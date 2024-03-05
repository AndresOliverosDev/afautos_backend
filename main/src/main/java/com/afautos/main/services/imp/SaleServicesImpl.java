package com.afautos.main.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afautos.main.models.Sale;
import com.afautos.main.repositories.SaleRepository;
import com.afautos.main.services.SaleService;

@Service
public class SaleServicesImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }
    

}
