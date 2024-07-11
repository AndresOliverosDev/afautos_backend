package com.afautos.businessmanagement.services.interfaces.transaction.sale;

import java.util.List;

import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.persistence.entity.transaction.sale.SaleDetailEntity;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.request.SaleDetailCreateDTO;
import com.afautos.businessmanagement.presentation.dto.transaction.sale.response.SaleDetailDTO;

public interface ISaleDetailService {

    List<SaleDetailDTO> getAllBySale(Long idSale) throws NotFoundException;

    List<SaleDetailEntity> createSaleDetail(List<SaleDetailCreateDTO> saleDetailCreateDTO, Long saleId) throws NotFoundException;

}
