package com.eshop.productservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product extends WhoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String productDescription;
    @Column(nullable = false)
    private Long productPrice;
    @Column(nullable = false)
    private String productCategory;
    @Column(nullable = false)
    private String productImage;
    @Column(nullable = false)
    private String productStatus;

}
