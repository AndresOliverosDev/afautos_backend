package com.afautos.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afautos.main.models.Sale;

@Service
public interface SaleService {

    List<Sale> getAllSales();

}
