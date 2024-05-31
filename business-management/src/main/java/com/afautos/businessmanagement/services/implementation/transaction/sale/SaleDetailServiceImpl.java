package com.afautos.businessmanagement.services.implementation.transaction.sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.product.ProductEntity;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleDetailEntity;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleEntity;
import com.afautos.businessmanagement.persistence.repository.product.ProductRepository;
import com.afautos.businessmanagement.persistence.repository.transaction.sale.SaleDetailRepository;
import com.afautos.businessmanagement.persistence.repository.transaction.sale.SaleRepository;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDetailCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.SaleDetailDTO;
import com.afautos.businessmanagement.services.interfaces.transaction.sale.ISaleDetailService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleDetailServiceImpl implements ISaleDetailService{

    // Dependency injection
    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    // Get all details by sale
    @Override
    public List<SaleDetailDTO> getAllBySale(Long idSale) throws LocalNotFoundException{
        List<SaleDetailDTO> saleDetail = saleDetailRepository.getAllBySale(idSale);

        return saleDetail;

    }

    // Create sale details to a sale
    @Override
    @Transactional
    public List<SaleDetailEntity> createSaleDetail(List<SaleDetailCreateDTO> saleDetailCreateDTO, Long saleId) {
        try {
            // Find sale and handle the exception
            SaleEntity sale = saleRepository.findById(saleId).orElseThrow(() ->
                    new LocalNotFoundException("El pedido con el id " + saleId + " no existe" )
            );

            List<SaleDetailEntity> saleDetailReturn = new ArrayList<>();

            // Map sale detail list
            for (SaleDetailCreateDTO saleDetail : saleDetailCreateDTO) {

                // Find product and handle exception
                ProductEntity product = productRepository.findById(saleDetail.productId()).orElseThrow(() ->
                    new LocalNotFoundException("El pedido con el id " + saleId + " no existe"));

                SaleDetailEntity saleDetailEntity = getSaleDetailEntity(saleDetail, product, sale);

                saleDetailRepository.save(saleDetailEntity);
                saleDetailReturn.add(saleDetailEntity);
            }

            return saleDetailReturn;

        } catch (Exception e) {
            throw new RuntimeException("Error al crear los detalles de venta", e);
        }
    }

    // Method to create sales detail entity
    private static SaleDetailEntity getSaleDetailEntity(SaleDetailCreateDTO saleDetail, ProductEntity product, SaleEntity sale) {
        BigDecimal quantityProduct = new BigDecimal(saleDetail.quantity());
        BigDecimal subtotalPrice = product.getPrice().multiply(quantityProduct);

        SaleDetailEntity saleDetailEntity = new SaleDetailEntity();
        saleDetailEntity.setProduct(product);
        saleDetailEntity.setSale(sale);
        saleDetailEntity.setQuantity(saleDetail.quantity());
        saleDetailEntity.setPriceUnit(product.getPrice());
        saleDetailEntity.setSubtotal(subtotalPrice);
        return saleDetailEntity;
    }

}
