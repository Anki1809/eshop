package com.eshop.productservice.dto;

import com.eshop.productservice.entity.Product;
import com.eshop.productservice.enums.Units;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */

public record ProductRequest(

        Long productId,

        @NotBlank(message = "Name must not be blank")
        @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
        String name,

        @Size(max = 1000, message = "Description must not exceed 1000 characters")
        String description,

        @NotNull(message = "Category ID must not be null")
        Long categoryId,

        Long imageId,

        @NotNull(message = "Unit must not be null")
        Units unit,

        @NotNull(message = "Shop ID must not be null")
        Long shopId
) implements Serializable {
}
