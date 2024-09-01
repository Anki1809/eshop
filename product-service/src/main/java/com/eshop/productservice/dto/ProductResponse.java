package com.eshop.productservice.dto;

import com.eshop.productservice.entity.Product;
import com.eshop.productservice.entity.ProductCategories;
import com.eshop.productservice.enums.Units;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Product}
 */
public record ProductResponse(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy,
                         Long productId, String name, String description, Long categoryId, Long imageId,
                         Boolean productStatus, Units unit, Long shopId,
                         ProductCategories productCategories) implements Serializable {
}