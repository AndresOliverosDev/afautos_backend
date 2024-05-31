package com.afautos.businessmanagement.services.implementation.transaction.sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.persistence.repository.transaction.sale.SaleRepository;
import com.afautos.businessmanagement.persistence.repository.user.UserRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<SaleDTO> getAll() {
        return saleRepository.getAll();
    }

    @Override
    public SaleDTO getSaleDTOById(Long id) throws LocalNotFoundException {
        SaleDTO sale = saleRepository.getSaleById(id);
        if (sale == null) {
            throw new LocalNotFoundException("Venta con el id " + id + " no existe");
        }
        return sale;
    }

    @Override
    public SaleEntity getSaleEntityById(Long id) throws LocalNotFoundException {
        SaleEntity sale = saleRepository.findById(id).orElse(null);
        if (sale == null) {
            throw new LocalNotFoundException("Venta con el id " + id + " no existe");
        }
        return sale;
    }

    @Override
    public SaleEntity createSale(SaleCreateDTO saleCreateDTO) throws LocalNotFoundException {

            UserEntity customer = userRepository.findById(saleCreateDTO.getCustomer()).orElse(null);
            if (customer == null) {
                throw new LocalNotFoundException("Cliente con el id " + saleCreateDTO.getCustomer() + " no existe");
            }

            LocalDateTime dataTime = LocalDateTime.now();

            SaleEntity saleEntity = new SaleEntity();
            saleEntity.setSaleDate(dataTime);
            saleEntity.setPayMethod(saleCreateDTO.getPayMethod());
            saleEntity.setAddress(saleCreateDTO.getAddress());
            saleEntity.setCustomer(customer);

            saleRepository.save(saleEntity);
            return saleEntity;
    }

    @Override
    public ResponseEntity<String> updateTotalPrice(BigDecimal totalPrice, Long saleId){
        try {
            SaleEntity saleEntity = saleRepository.findById(saleId).orElseThrow(() ->
                    new LocalNotFoundException(("La venta con el id " + saleId + " no existe")));
            
            saleEntity.setTotalPrice(totalPrice);
            saleRepository.save(saleEntity);
            return ResponseEntity.ok("El precio se actualizo correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el valor total");
        }
    }
}