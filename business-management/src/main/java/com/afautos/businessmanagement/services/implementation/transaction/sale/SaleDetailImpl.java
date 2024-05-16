package com.afautos.businessmanagement.services.implementation.transaction.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.persistence.repository.transaction.sale.SaleDetailRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDetailDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleDetailService;

@Service
public class SaleDetailImpl implements ISaleDetailService{

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Override
    public List<SaleDetailDTO> getAll() {
        return saleDetailRepository.getAll();
    }
    
}
