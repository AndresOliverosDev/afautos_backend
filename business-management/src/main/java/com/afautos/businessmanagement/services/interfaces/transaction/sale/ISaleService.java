package com.afautos.businessmanagement.services.interfaces.transaction.sale;

import java.util.List;

import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;

public interface ISaleService {
    List<SaleEntity> getAll();
}
