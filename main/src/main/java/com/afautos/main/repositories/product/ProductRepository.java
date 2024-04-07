package com.afautos.main.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afautos.main.dto.product.ProductDTO;
import com.afautos.main.models.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("SELECT new com.afautos.main.dto.product.ProductDTO (p.id, p.name, p.desc, p.quantity, p.price, p.imageUrl, p.cat.name, p.brand.name) FROM Product p")
    List<ProductDTO> getAllProducts();
}
