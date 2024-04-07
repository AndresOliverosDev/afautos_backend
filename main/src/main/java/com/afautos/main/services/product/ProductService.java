package com.afautos.main.services.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afautos.main.dto.product.ProductDTO;
import com.afautos.main.models.product.Product;

@Service
public interface ProductService {
    
    String addProduct(Product product);

    String delProduct(Long id);

    String updateProduct(Long id, Product product);

    List<ProductDTO> getAllProducts();

    Product getByIdProduct(Long id);

    Product getbyNameProduct(String name);

    Product getByCatProduct(String cat);

    Product getByBrandProduct(String brand);
}
