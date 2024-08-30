package com.eshop.productservice.service;


import com.eshop.productservice.dto.ProductRequest;
import com.eshop.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    /**
     *
     * @param productRequest
     * @return
     */
    ProductResponse addProduct(ProductRequest productRequest);

    /**
     *
     * @param productRequest
     * @return
     */
    ProductResponse updateProduct(ProductRequest productRequest);

    /**
     *
     * @param productId
     * @return
     */
    Boolean deactivateProduct(Long productId);

    /**
     *
     * @return
     */
    List<ProductResponse> getAllProducts();

    /**
     *
     * @param productId
     * @return
     */
    ProductResponse getProductById(Long productId);

}
