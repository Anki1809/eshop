package com.eshop.shopservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "Shop", uniqueConstraints = {
        @UniqueConstraint(name = "uc_shop_name_ownerid", columnNames = {"name", "ownerId"})
})
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
    @Column(nullable = false)
    private String ownerId;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    private Boolean active;

}
