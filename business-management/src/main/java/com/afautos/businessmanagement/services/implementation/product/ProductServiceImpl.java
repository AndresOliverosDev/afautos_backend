package com.afautos.businessmanagement.services.implementation.product;

import java.util.List;
import java.util.Optional;

import com.afautos.businessmanagement.error.BadRequest;
import com.afautos.businessmanagement.error.GeneralException;
import com.afautos.businessmanagement.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afautos.businessmanagement.persistence.entity.product.BrandEntity;
import com.afautos.businessmanagement.persistence.entity.product.CategoryEntity;
import com.afautos.businessmanagement.persistence.entity.product.ProductEntity;
import com.afautos.businessmanagement.persistence.repository.product.BrandRepository;
import com.afautos.businessmanagement.persistence.repository.product.CategoryRepository;
import com.afautos.businessmanagement.persistence.repository.product.ProductRepository;
import com.afautos.businessmanagement.presentation.dto.product.request.ProductAddDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO;
import com.afautos.businessmanagement.services.interfaces.product.IProductService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements IProductService {

    // Dependency injection
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Find
    @Override
    public List<ProductDTO> getAllProd() {
        return productRepository.getAll();
    }

    // Find entities
    @Override
    public Optional<ProductEntity> getProductEntityById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public ProductDTO addProd(ProductAddDTO productDTO) {
        try {

            Optional<ProductEntity> productNameExist = productRepository.findByname(productDTO.name());
            if (productNameExist.isPresent()) {
                throw new BadRequest("El nombre " + productDTO.name() + " ya existe, use otro nombre");
            }
            // Obtener marca y categoría
            BrandEntity brandCurrent = brandRepository.findById(productDTO.brand()).orElse(null);
            if (brandCurrent == null) {
                throw new NotFoundException("Marca no encontrada");
            }
            CategoryEntity categoryCurrent = categoryRepository.findById(productDTO.category()).orElse(null);
            if (categoryCurrent == null) {
                throw new NotFoundException("Categoría no encontrada");
            }

            // Crear entidad de producto
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productDTO.name());
            productEntity.setDesc(productDTO.desc());
            productEntity.setImage(productDTO.image());
            productEntity.setPrice(productDTO.price());
            productEntity.setQuantity(productDTO.quantity());
            productEntity.setBrand(brandCurrent);
            productEntity.setCategory(categoryCurrent);

            // Guardar en la base de datos
            productEntity = productRepository.save(productEntity);

            // Convertir la entidad guardada a DTO
            return convertToDTO(productEntity);

        } catch (GeneralException e) {
            throw new GeneralException("Error al crear el producto");
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Conversión de ProductEntity a ProductDTO
    private ProductDTO convertToDTO(ProductEntity productEntity) {
        return new ProductDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDesc(),
                productEntity.getQuantity(),
                productEntity.getPrice(),
                productEntity.getImage(),
                productEntity.getBrand().getName(),
                productEntity.getCategory().getName()
        );
    }

    @Override
    public ResponseEntity<String> delProd(Long id) {
        try {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto con el ID especificado no existe");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error del servidor, no se pudo eliminar el producto");
        }
    }

    @Override
    public ResponseEntity<String> updateProd(Long id, ProductAddDTO productDTO) {
        try {
            ProductEntity productCurrent = productRepository.findById(id).orElse(null);
            if (productCurrent == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El id " + id + " no existe en la base de datos");
            }

            BrandEntity brandCurrent = brandRepository.findById(productDTO.brand()).orElse(null);
            if (brandCurrent == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Marca no encontrada");
            }
            CategoryEntity categoryCurrent = categoryRepository.findById(productDTO.category()).orElse(null);
            if (categoryCurrent == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría no encontrada");
            }

            productCurrent.setName(productDTO.name());
            productCurrent.setDesc(productDTO.desc());
            productCurrent.setQuantity(productDTO.quantity());
            productCurrent.setPrice(productDTO.price());
            productCurrent.setImage(productDTO.image());
            productCurrent.setBrand(brandCurrent);
            productCurrent.setCategory(categoryCurrent);

            productRepository.save(productCurrent);

            return ResponseEntity.ok("El producto con el ID " + id + " se actualizo correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El producto con el ID " + id + " no existe");
        }
    }

}
