package com.eshop.productservice.service;


import com.eshop.productservice.dto.ProductRequest;
import com.eshop.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest);

    ProductResponse updateProduct(ProductRequest productRequest);

    Boolean productStatus(Long productId, Boolean status);

    List<ProductResponse> getAllProducts(Boolean status);

    ProductResponse getProductById(Long productId);

    List<ProductResponse> getAllProductsByShopId(Long shopId);

    List<ProductResponse> getAllProductsByCategoryId(Long shopId, Long categoryId);

}
