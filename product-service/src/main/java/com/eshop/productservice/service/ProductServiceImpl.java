package com.eshop.productservice.service;

import com.eshop.productservice.dto.ProductRequest;
import com.eshop.productservice.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    /**
     * @param productRequest
     * @return
     */
    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        return null;
    }

    /**
     * @param productRequest
     * @return
     */
    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        return null;
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public Boolean deactivateProduct(Long productId) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<ProductResponse> getAllProducts() {
        return List.of();
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public ProductResponse getProductById(Long productId) {
        return null;
    }
}
