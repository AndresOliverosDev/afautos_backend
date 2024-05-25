package com.afautos.businessmanagement.services.implementation.transaction.sale;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.persistence.repository.transaction.sale.SaleRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SaleServiceImpl implements ISaleService{

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<SaleDTO> getAll() {
        return saleRepository.getAll();
    }

    @Override
    public Optional<SaleDTO> getById(Long id) {
        return Optional.of(saleRepository.getSaleById(id).orElseThrow(
            () -> new  EntityNotFoundException("La venta con el id " + id + " no existe ")
        ));
    }
    
}
