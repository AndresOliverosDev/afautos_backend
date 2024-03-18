package com.afautos.main.services.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afautos.main.models.transaction.Sale;

@Service
public interface SaleService {

    List<Sale> getAllSales();

}
