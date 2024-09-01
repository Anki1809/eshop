package com.eshop.productservice.dao;

import com.eshop.productservice.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
    Optional<ProductPrice> findByPriceId(Long priceId);

    List<ProductPrice> findByProductId(Long productId);
}