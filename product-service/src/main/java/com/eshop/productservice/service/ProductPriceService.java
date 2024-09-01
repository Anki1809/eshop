package com.eshop.productservice.service;

import com.eshop.productservice.entity.ProductPrice;

import java.util.List;

public interface ProductPriceService {

    ProductPrice createProductPrice(ProductPrice productPrice);
    ProductPrice updateProductPrice(ProductPrice productPrice);
    ProductPrice getProductPrice(Long priceId);
    List<ProductPrice> getAllProductPriceByProductId(Long productId);
}
