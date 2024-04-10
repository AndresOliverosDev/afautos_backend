package com.afautos.main.services.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afautos.main.dto.product.ProductAddDTO;
import com.afautos.main.dto.product.ProductDTO;
import com.afautos.main.models.product.Product;

@Service
public interface ProductService {
    
    ResponseEntity<String> addProduct(ProductAddDTO productAddDTO);

    ResponseEntity<String> delProduct(Long id);

    String updateProduct(Long id, Product product);

    List<ProductDTO> getAllProducts();

    Product getByIdProduct(Long id);

    Product getbyNameProduct(String name);

    Product getByCatProduct(String cat);

    Product getByBrandProduct(String brand);
}
