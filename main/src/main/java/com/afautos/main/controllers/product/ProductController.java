package com.afautos.main.controllers.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.main.dto.ProductDTO;
import com.afautos.main.models.product.Product;
import com.afautos.main.services.product.ProductService;
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

    @PostMapping("/getAllProd")
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProducts();
    }
}