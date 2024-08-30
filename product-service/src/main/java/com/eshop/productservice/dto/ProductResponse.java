package com.eshop.productservice.dto;

import com.eshop.productservice.entity.Product;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
public record ProductResponse(Long productId, String name, String description, Long price, Long categoryId, Long imageId,
                              Boolean productStatus) implements Serializable {
}