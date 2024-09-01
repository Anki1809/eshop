package com.eshop.productservice.entity;

import com.eshop.productservice.enums.Units;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Product extends WhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long categoryId;

    @Column
    private Long imageId;

    @Column(columnDefinition = "boolean default true")
    private Boolean productStatus;

    @Column(nullable = false)
    private Units unit;

    private Long shopId;

}
