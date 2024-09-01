package com.eshop.productservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
public class ProductPrice extends WhoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "price_id", nullable = false)
  private Long priceId;

  @Column(nullable = false)
  @PositiveOrZero(message = "Enter valid positive price.")
  private Double price;

  @PositiveOrZero(message = "Enter valid positive unit of value.")
  @Column(nullable = false)
  private Double unitOf;

  @PositiveOrZero(message = "Enter valid positive quantity.")
  @Column(nullable = false)
  private Long QuantityAvailable;

  @Column(columnDefinition = "boolean default true")
  private Boolean status;

  @PositiveOrZero(message = "Enter valid positive discount.")
  @Column(nullable = false)
  private Double discount;

  @PositiveOrZero(message = "Enter valid product id.")
  @Column(nullable = false)
  private Long productId;

}