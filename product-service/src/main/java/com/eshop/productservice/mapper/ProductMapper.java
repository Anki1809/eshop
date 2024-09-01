package com.eshop.productservice.mapper;


import com.eshop.productservice.dto.ProductRequest;
import com.eshop.productservice.dto.ProductResponse;
import com.eshop.productservice.entity.Product;
import com.eshop.productservice.entity.ProductCategories;

public class ProductMapper {
    public static Product mapToProduct( ProductRequest productRequest, Product product) {
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setCategoryId(productRequest.categoryId());
        product.setUnit(productRequest.unit());
        product.setImageId(productRequest.imageId());
        product.setShopId(productRequest.shopId());
        return product;
    }

    public static ProductResponse mapToProductResponse(Product product, ProductCategories productCategories) {
        return new ProductResponse(
                product.getCreatedAt(),
                product.getCreatedBy(),
                product.getUpdatedAt(),
                product.getUpdatedBy(),
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getCategoryId(),
                product.getImageId(),
                product.getProductStatus(),
                product.getUnit(),
                product.getShopId(),
                productCategories
        );
    }
}
