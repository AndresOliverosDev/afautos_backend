package com.afautos.businessmanagement.persistence.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.product.ProductEntity;
import com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO(p.id, p.name, p.desc, p.quantity, p.price, p.image, p.category.name, p.brand.name) FROM ProductEntity p")
    List<ProductDTO> getAll();
}
