package com.eshop.productservice.entity;

import com.eshop.productservice.enums.Units;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    private Long price;
    @Column(nullable = false)
    private Long categoryId;
    @Column
    private Long imageId;
    @Column(columnDefinition = "default true")
    private Boolean productStatus;
    private Units unit;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ProductPrice> productPrices = new ArrayList<>();

}
