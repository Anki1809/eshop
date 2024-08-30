package com.eshop.shopservice.mapper;

import com.eshop.shopservice.entity.Shop;
import com.eshop.shopservice.dto.ShopDto;

public class ShopMapper {

    public static ShopDto toShopDto(Shop shop) {
        return new ShopDto(
                shop.getShopId(),shop.getName(),shop.getAddress(),shop.getCity()
                ,shop.getState(),shop.getZip(),shop.getPhone(),shop.getEmail()
        );
    }

    public static Shop toShop(ShopDto shopDto, Shop shop) {
        shop.setShopId(shopDto.shopId());
        shop.setName(shopDto.name());
        shop.setAddress(shopDto.address());
        shop.setCity(shopDto.city().toUpperCase());
        shop.setState(shopDto.state().toUpperCase());
        shop.setZip(shopDto.zip());
        shop.setPhone(shopDto.phone());
        shop.setEmail(shopDto.email().toLowerCase());
        return shop;
    }
}
