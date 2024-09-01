package com.eshop.productservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class ProductCategories extends WhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long productCategoryId;

    @NotBlank(message = "Enter valid category name.")
    @Size(min = 3, max = 50, message = "Enter valid category name between 3 to 50.")
    private String name;

    @Size(min = 3, max = 50, message = "Enter a valid sub category name between 3 to 50.")
    private String subName;

}