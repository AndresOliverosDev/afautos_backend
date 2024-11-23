package com.afautos.businessmanagement.services.implementation.product;

import com.afautos.businessmanagement.error.AttributeAlreadyExists;
import com.afautos.businessmanagement.error.BadRequest;
import com.afautos.businessmanagement.error.GeneralException;
import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.persistence.entity.product.BrandEntity;
import com.afautos.businessmanagement.persistence.repository.product.BrandRepository;
import com.afautos.businessmanagement.persistence.repository.product.ProductRepository;
import com.afautos.businessmanagement.presentation.dto.product.request.BrandRequestDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.brand.BrandResponseDTO;
import com.afautos.businessmanagement.services.interfaces.product.IBrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements IBrandService {

    // Dependency injection
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;

    public BrandServiceImpl(BrandRepository brandRepository, ProductRepository productRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
    }

    // Obtener todas las marcas
    @Override
    public List<BrandResponseDTO> getAllBrands () {
        try {
            return brandRepository.getAllBrands();
        } catch (GeneralException e) {
            throw new GeneralException("Error al obtener las marcas");
        }
    }

    // Crear una nueva marca
    @Override
    public BrandEntity createBrand(BrandRequestDTO brand) {
        try {
            // Verificar si el nombre ya existe en la base de datos
            Optional<BrandEntity> verifyBrand = brandRepository.findByName(brand.name());
            if (verifyBrand.isPresent()) {
                throw new AttributeAlreadyExists("La marca con el nombre " + brand.name() + " ya existe");
            }
            // Crear la marca
            BrandEntity brandEntity = new BrandEntity();
            brandEntity.setName(brand.name());
            return brandRepository.save(brandEntity);
        } catch (GeneralException e) {
            throw new GeneralException("Error al intentar crear la marca");
        }
    }

    // Eliminar una marca
    @Override
    public BrandEntity deleteBrand(Short id) {
        try {
            // Verificar si la marca si existe
            Optional<BrandEntity> brandCurrent = brandRepository.findById(id);
            if (brandCurrent.isEmpty()) {
                throw new NotFoundException("La marca con id " + id + " no existe");
            }
            // Verificar que no hayan productos asociados a la marca
            List<ProductDTO> productAssociated = productRepository.getAllProductsByBrand(id);
            if (!productAssociated.isEmpty()) {
                throw new BadRequest("No se puede eliminar la marca, tiene productos asociados");
            }
            // Eliminar producto
            brandRepository.deleteById(id);
            return brandCurrent.get();
        } catch (GeneralException e) {
            throw new GeneralException("Error al eliminar la marca");
        }
    }

    // Actualizar una marca
    @Override
    public BrandEntity updateBrand(BrandRequestDTO brand, Short brandID) {
        try {
            // Validar si la marca existe
            Optional<BrandEntity> brandEntity = brandRepository.findById(brandID);
            if (brandEntity.isEmpty()) {
                throw new NotFoundException("No se encontró la marca con el id " + brandID);
            }
            // Validar si el nombre a actualizar ya existe
            Optional<BrandEntity> brandVerify = brandRepository.findByName(brand.name());
            if (brandVerify.isPresent()) {
                throw new AttributeAlreadyExists("El nombre '" + brand.name() + "' ya esta en uso, por la marca con id " + brandVerify.get().getId());
            }

            // Actualizar la marca
            brandEntity.get().setName(brand.name());
            return brandRepository.save(brandEntity.get());
        }
        catch (GeneralException e) {
            throw new GeneralException("No se logro actualizar la marca");
        }
    }
}
