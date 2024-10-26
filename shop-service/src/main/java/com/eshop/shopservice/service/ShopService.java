package com.eshop.shopservice.service;

import com.eshop.shopservice.dto.ShopDto;

import java.util.List;

public interface ShopService {
    ShopDto addShop(ShopDto shopDto, String userId);
    ShopDto updateShop(ShopDto shopDto);
    ShopDto getShopById(Long shopId);
    List<ShopDto> getShops(Boolean active);
    ShopDto getShopByOwnerId(String ownerId);
    Boolean deactivateShop(Boolean active, Long shopId);
    Boolean shopExistWithOwnerId(String ownerId);
    String getOwnerIdByShopId(Long shopId);
}
