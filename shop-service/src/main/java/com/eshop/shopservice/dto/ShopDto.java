package com.eshop.shopservice.dto;


import com.eshop.shopservice.entity.Shop;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link Shop}
 */
public record ShopDto(
        Long shopId,

        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name cannot be longer than 100 characters")
        String name,

        @NotBlank(message = "Address is required")
        @Size(max = 255, message = "Address cannot be longer than 255 characters")
        String address,

        @NotBlank(message = "City is required")
        @Size(max = 100, message = "City cannot be longer than 100 characters")
        String city,

        @NotBlank(message = "State is required")
        @Size(max = 100, message = "State cannot be longer than 100 characters")
        String state,

        @NotBlank(message = "Zip code is required")
        @Pattern(regexp = "\\d{6}", message = "Zip code must be exactly 6 digits")
        String zip,

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^\\+\\d{12}$", message = "Phone number must be in the format +919876543210 with 12 digits after the +")
        String phone,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email
) implements Serializable {
}
