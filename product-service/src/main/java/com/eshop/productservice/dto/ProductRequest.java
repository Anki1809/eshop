package com.eshop.productservice.dto;

import com.eshop.productservice.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
public record ProductRequest(
        @Size(message = "Enter valid product length 3 to 100.", min = 3, max = 100)
        @NotBlank(message = "Enter valid product name")
        String name,
        @Size(message = "Enter valid product description 5 to 255 character.", min = 5, max = 255)
        @NotBlank(message = "Enter valid product description.")
        String description,
        @PositiveOrZero(message = "Enter valid product price non zero and positive.")
        Long price,
        @PositiveOrZero(message = "Enter valid product price non zero and positive.")
        Long categoryId) implements Serializable {
}