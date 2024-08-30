package com.eshop.productservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ProductPrice {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "price_id", nullable = false)
  private Long priceId;

  @ManyToOne(optional = false)
  @JoinColumn(name = "product_product_id", nullable = false, unique = true)
  private Product product;

  private Double price;

  private Long QuantityAvailable;

}