package com.afautos.main.services.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.afautos.main.dto.product.ProductAddDTO;
import com.afautos.main.dto.product.ProductDTO;
import com.afautos.main.models.product.Brand;
import com.afautos.main.models.product.Category;
import com.afautos.main.models.product.Product;
import com.afautos.main.repositories.product.BrandRepository;
import com.afautos.main.repositories.product.CategoryRepository;
import com.afautos.main.repositories.product.ProductRepository;
import com.afautos.main.services.product.ProductService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<String> addProduct(ProductAddDTO productAddDTO) {
        try{

            Brand brand = brandRepository.findById(productAddDTO.getBrand()).orElse(null);
            if (brand == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Marca no encontrada");
            }

            Category category = categoryRepository.findById(productAddDTO.getCat()).orElse(null);
            if (category == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Categoría no encontrada");
            }

            Product product = new Product();

            product.setName(productAddDTO.getName());
            product.setDesc(productAddDTO.getDesc());
            product.setImageUrl(productAddDTO.getImageUrl());
            product.setPrice(productAddDTO.getPrice());
            product.setQuantity(productAddDTO.getQuantity());
            product.setBrand(brand);
            product.setCat(category);

            productRepository.save(product);

            return ResponseEntity.ok("Producto creado correctamente");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el producto");
        }
    }

    @Override
    public ResponseEntity<String> delProduct(Long id) {
        try{
            productRepository.deleteById(id);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto con el ID especificado no existe");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error del servidor, no se pudo eliminar el producto");
        }
    }

    @Override
    public String updateProduct(Long id, Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public Product getByIdProduct(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByIdProduct'");
    }

    @Override
    public Product getbyNameProduct(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getbyNameProduct'");
    }

    @Override
    public Product getByCatProduct(String cat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByCatProduct'");
    }

    @Override
    public Product getByBrandProduct(String brand) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByBrandProduct'");
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.getAllProducts();
    }
    
}
