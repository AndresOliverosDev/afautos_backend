package com.afautos.businessmanagement.presentation.controller.product;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afautos.businessmanagement.presentation.dto.product.request.ProductAddDTO;
import com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO;
import com.afautos.businessmanagement.services.interfaces.product.IProductService;
@Tag(name = "Productos", description = "El controlador de productos proporciona una serie de endpoints para gestionar productos dentro del sistema.")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Obtener todos los productos", description = "Recupera una lista de todos los productos disponibles en el sistema")
    @PreAuthorize("hasAuthority('DELETE')")
    @GetMapping("/getAll")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProd();
    }

    @Operation(summary = "Agregar un nuevo producto", description = "Agrega un nuevo producto al sistema")
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductAddDTO productDTO) {
        return productService.addProd(productDTO);
    }

    @Operation(summary = "Eliminar un producto por ID", description = "Elimina un producto específico del sistema basado en su ID")
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return productService.delProd(id);
    }

    @Operation(summary = "Actualizar un producto", description = "Actualiza los detalles de un producto existente en el sistema basado en su ID")
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductAddDTO productDTO) {
        return productService.updateProd(id, productDTO);
    }
}
