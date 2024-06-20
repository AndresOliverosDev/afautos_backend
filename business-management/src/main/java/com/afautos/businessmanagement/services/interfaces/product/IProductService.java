package com.afautos.businessmanagement.services.interfaces.product;

import java.util.List;

import com.afautos.businessmanagement.persistence.entity.product.ProductEntity;
import org.springframework.http.ResponseEntity;

import com.afautos.businessmanagement.presentation.dto.product.request.ProductAddDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO;

public interface IProductService {
    // Read
    List<ProductDTO> getAllProd();

    ProductEntity getProductEntityById(Long productId);
    //Create
    ResponseEntity<String> addProd(ProductAddDTO productDTO);

    ResponseEntity<String> delProd(Long id);

    ResponseEntity<String> updateProd(Long id, ProductAddDTO productDTO);
}
