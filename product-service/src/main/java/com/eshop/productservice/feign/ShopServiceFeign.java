package com.eshop.productservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("shop-service")
public interface ShopServiceFeign {
    @GetMapping("/api/{shopId}/{ownerId}")
    Boolean existOwnerAndShopId(@PathVariable String ownerId, @PathVariable Long shopId);
}
