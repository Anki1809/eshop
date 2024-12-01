package com.eshop.productservice.service;

import com.eshop.productservice.entity.ProductPrice;

import java.util.List;

public interface ProductPriceService {

    ProductPrice createProductPrice(ProductPrice productPrice, String userId);
    ProductPrice updateProductPrice(ProductPrice productPrice, String userId);
    ProductPrice getProductPrice(Long priceId);
    List<ProductPrice> getAllProductPriceByProductId(Long productId);
}
