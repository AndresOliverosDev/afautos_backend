package com.afautos.businessmanagement.presentation.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.businessmanagement.presentation.dto.product.ProductAddDTO;
import com.afautos.businessmanagement.presentation.dto.product.ProductDTO;
import com.afautos.businessmanagement.services.interfaces.product.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/getAll")
    public List<ProductDTO> getAll() {
        return productService.getAllProd();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProd(@RequestBody ProductAddDTO productDTO) {
        return productService.addProd(productDTO);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> delProd(@PathVariable Long id) {
        return productService.delProd(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateProd(@PathVariable Long id, @RequestBody ProductAddDTO productDTO) {
        return productService.updateProd(id, productDTO);
    }
}
