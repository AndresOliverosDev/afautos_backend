package com.afautos.businessmanagement.services.implementation.transaction.sale;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.afautos.businessmanagement.services.interfaces.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.persistence.repository.transaction.sale.SaleRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.request.SaleCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;

@Service
public class SaleServiceImpl implements ISaleService {

    // Dependency injection

    private final IUserService userService;
    private final SaleRepository saleRepository;

    public SaleServiceImpl(IUserService userService, SaleRepository saleRepository) {
        this.userService = userService;
        this.saleRepository = saleRepository;
    }

// Read

    @Override
    public ResponseEntity<?> getSalesByCustomer(String customer) {
        try {
            UserEntity userEntity = userService.getUserEntityById(customer);
            if (userEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente con id " + customer + " no existe");
            }

            List<SaleDTO> saleDTOList = saleRepository.getSalesByCustomer(customer);

            return ResponseEntity.ok(saleDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las ventas del usuario");
        }
    }

    @Override
    public List<SaleDTO> getAll() {
        return saleRepository.getAll();
    }

    @Override
    public SaleDTO getSaleDTOById(Long id) throws NotFoundException {
        SaleDTO sale = saleRepository.getSaleById(id);
        if (sale == null) {
            throw new NotFoundException("Venta con el id " + id + " no existe");
        }
        return sale;
    }

    @Override
    public SaleEntity getSaleEntityById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Override
    public SaleEntity createSale(SaleCreateDTO saleCreateDTO) throws NotFoundException {

            UserEntity customer = userService.getUserEntityById(saleCreateDTO.getCustomer());
            if (customer == null) {
                throw new NotFoundException("Cliente con el id " + saleCreateDTO.getCustomer() + " no existe");
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
    public void updateTotalPrice(BigDecimal totalPrice, Long saleId){
        try {
            SaleEntity saleEntity = saleRepository.findById(saleId).orElseThrow(() ->
                    new NotFoundException(("La venta con el id " + saleId + " no existe")));
            
            saleEntity.setTotalPrice(totalPrice);
            saleRepository.save(saleEntity);
            ResponseEntity.ok("El precio se actualizo correctamente");
        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el valor total");
        }
    }

}