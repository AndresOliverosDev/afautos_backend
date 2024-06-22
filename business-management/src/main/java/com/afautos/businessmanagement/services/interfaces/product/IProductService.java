package com.afautos.businessmanagement.services.interfaces.product;

import java.util.List;
import java.util.Optional;

import com.afautos.businessmanagement.persistence.entity.product.ProductEntity;
import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.presentation.dto.product.request.ProductAddDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO;

public interface IProductService {

    // Find

    List<ProductDTO> getAllProd();

    // Find entities
    Optional<ProductEntity> getProductEntityById(Long productId);

    ResponseEntity<String> addProd(ProductAddDTO productDTO);

    ResponseEntity<String> delProd(Long id);

    ResponseEntity<String> updateProd(Long id, ProductAddDTO productDTO);
}
