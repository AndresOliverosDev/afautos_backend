package com.afautos.businessmanagement.services.implementation.transaction.sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDetailCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDetailDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleManagementDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleDetailService;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleManagementService;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleService;

@Service
public class SaleManagementServiceImpl implements ISaleManagementService {

    @Autowired
    private ISaleService saleService;

    @Autowired
    private ISaleDetailService saleDetailService;

    @Override
    public List<SaleManagementDTO> getAllSalesDto() {
        try {

            List<SaleManagementDTO> saleManagementList = new ArrayList<>();

            List<SaleDTO> saleList = saleService.getAll();

            for (SaleDTO sale : saleList) {
                List<SaleDetailDTO> saleDetailDTOList = saleDetailService.getAllBySale(sale.id());
                saleManagementList.add(new SaleManagementDTO(sale, saleDetailDTOList));
            }
            return saleManagementList;
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar las ventas", e);
        }
    }

    @Override
    public SaleManagementDTO getById(Long saleId) throws LocalNotFoundException {

        SaleDTO sale = saleService.getSaleDTOById(saleId);

        List<SaleDetailDTO> saleDetail = saleDetailService.getAllBySale(saleId);

        return new SaleManagementDTO(sale, saleDetail);
    }

    @Override
    public ResponseEntity<String> createSaleWithSaleDetail(SaleCreateDTO saleCreateDTO,
            List<SaleDetailCreateDTO> saleDetailCreateDTO) {

        try {
            SaleEntity saleEntity =  saleService.createSale(saleCreateDTO);

            List<SaleDetailEntity> saleDetailList =  saleDetailService.createSaleDetail(saleDetailCreateDTO, saleEntity.getId());

            // Map sales detail list to calculate the total price of a sale;
            BigDecimal totalSalePrice = BigDecimal.ZERO;
            for(SaleDetailEntity saleDetail : saleDetailList) {
                totalSalePrice = totalSalePrice.add(saleDetail.getSubtotal());
            }

            // Edit total sale price of the sale
            saleService.updateTotalPrice(totalSalePrice, saleEntity.getId());

            return ResponseEntity.ok("Venta creada correctamente");
        } catch (Exception e) {
            throw new RuntimeException("Error al crear la venta",e);
        }
    }

}
