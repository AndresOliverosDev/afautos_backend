package com.afautos.businessmanagement.services.implementation.transaction.sale;

import org.springframework.beans.factory.annotation.Autowired;

import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleManagementDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleDetailService;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleManagementService;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;

public class SaleManagementServiceImpl implements ISaleManagementService{

    @Autowired
    private ISaleService saleService;

    @Autowired
    private ISaleDetailService saleDetailService;

    @Override
    public SaleManagementDTO getById(Long SaleId) {
        try {
            SaleDTO sale = saleService.getById(SaleId);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
    
}
