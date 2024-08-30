package com.eshop.shopservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Shop extends WhoEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long shopId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String zip;
    @Column
    private String phone;
    @Column
    private String email;
    @Column(unique = true, nullable = false)
    private Long ownerId;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    private Boolean active;

}
