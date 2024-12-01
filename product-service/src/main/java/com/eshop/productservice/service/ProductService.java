package com.eshop.productservice.service;


import com.eshop.productservice.dto.ProductRequest;
import com.eshop.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    Boolean checkShopIdAndUserId(Long shopId, String userId);

    ProductResponse addProduct(ProductRequest productRequest,String userId);

    ProductResponse updateProduct(ProductRequest productRequest, String userId);

    Boolean productStatus(Long productId, Boolean status, String userId);

    List<ProductResponse> getAllProducts(Boolean status);

    ProductResponse getProductById(Long productId);

    List<ProductResponse> getAllProductsByShopId(Long shopId);

    List<ProductResponse> getAllProductsByCategoryId(Long shopId, Long categoryId);

    Boolean existsProductIdAndShopId(Long productId, String shopId);

}
