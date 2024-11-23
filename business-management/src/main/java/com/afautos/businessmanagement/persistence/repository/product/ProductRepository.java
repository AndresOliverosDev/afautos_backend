package com.afautos.businessmanagement.persistence.repository.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.afautos.businessmanagement.persistence.entity.product.ProductEntity;
import com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO" +
            "(p.id, p.name, p.desc, p.quantity, p.price, p.image, p.category.name, p.brand.name) " +
            "FROM ProductEntity p " +
            "WHERE p.isDelete = false")
    List<ProductDTO> getAll();

    // Get All products by category
    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO" +
            "(p.id, p.name, p.desc, p.quantity, p.price, p.image, p.category.name, p.brand.name) " +
            "FROM ProductEntity p " +
            "WHERE p.category.id = :category")
    List<ProductDTO> getProductsByCategory(@Param("category") Byte categoryID);

    // Obtener los productos asociados a una marca
    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.product.response.ProductDTO" +
            "(p.id, p.name, p.desc, p.quantity, p.price, p.image, p.category.name, p.brand.name) " +
            "FROM ProductEntity p " +
            "WHERE p.brand.id = :brand")
    List<ProductDTO> getAllProductsByBrand(@Param("brand") Short brandID);

    Optional<ProductEntity> findByName(String name);
}
