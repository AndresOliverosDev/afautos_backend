package com.afautos.businessmanagement.services.implementation.transaction.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.persistence.repository.transaction.sale.SaleRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;

@Service
public class SaleServiceImpl implements ISaleService{

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<SaleDTO> getAll() {
        return saleRepository.getAll();
    }
    
}
