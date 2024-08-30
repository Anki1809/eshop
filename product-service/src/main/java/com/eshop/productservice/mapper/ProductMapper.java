package com.eshop.productservice.mapper;


import com.eshop.productservice.dto.ProductRequest;
import com.eshop.productservice.dto.ProductResponse;
import com.eshop.productservice.entity.Product;

public class ProductMapper {
    public static Product mapToProduct(Product product, ProductRequest productRequest) {
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setDescription(productRequest.description());
        product.setCategoryId(productRequest.categoryId());
        return product;
    }

    public static ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(product.getProductId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getCategoryId(), product.getImageId(), product.getProductStatus());
    }
}
