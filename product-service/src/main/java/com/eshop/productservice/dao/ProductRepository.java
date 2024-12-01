package com.eshop.productservice.dao;

import com.eshop.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByProductId(Long productId);

    @Transactional
    @Modifying
    @Query("update Product p set p.productStatus = ?1 where p.productId = ?2")
    int updateProductStatusByProductId(Boolean productStatus, Long productId);


    List<Product> findByProductStatus(Boolean productStatus);

    @Query("select p.shopId from Product p where p.productId = ?1")
    Long getShopIdByProductId(Long productId);

    boolean existsByShopId(Long shopId);

    List<Product> findByShopId(Long shopId);

    List<Product> findByShopIdAndCategoryId(Long shopId, Long categoryId);

    boolean existsByProductIdAndProductStatus(Long productId, Boolean productStatus);

    Optional<Product> findByProductIdAndShopId(Long productId, Long shopId);


}