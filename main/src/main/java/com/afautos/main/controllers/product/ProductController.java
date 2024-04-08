package com.afautos.main.controllers.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.main.dto.product.ProductDTO;
import com.afautos.main.models.product.Product;
import com.afautos.main.services.product.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ProductController {
    
    @Autowired
    ProductService productService;

    @PostMapping("/addProd")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/deleteProd/{id}")
    public ResponseEntity<String> deleteProd(@PathVariable Long id) {
        return productService.delProduct(id);
    }

    @PostMapping("/getAllProd")
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProducts();
    }
}