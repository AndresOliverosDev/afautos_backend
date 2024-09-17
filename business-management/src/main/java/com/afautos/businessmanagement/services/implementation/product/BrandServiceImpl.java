package com.afautos.businessmanagement.services.implementation.product;

import com.afautos.businessmanagement.error.GeneralException;
import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.persistence.entity.product.BrandEntity;
import com.afautos.businessmanagement.persistence.repository.product.BrandRepository;
import com.afautos.businessmanagement.presentation.dto.product.response.brand.BrandResponseDTO;
import com.afautos.businessmanagement.services.interfaces.product.IBrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    // Dependency injection

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandResponseDTO> getAllBrands () {
        try {
            return brandRepository.getAllBrands();
        } catch (GeneralException e) {
            throw new GeneralException("Error al obtener las marcas");
        }
    }
}
