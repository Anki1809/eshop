package com.eshop.productservice.service;

import com.eshop.productservice.entity.ProductCategories;

import java.util.List;

public interface ProductCategoryService {

    ProductCategories addProductCategories(ProductCategories productCategories);

    ProductCategories updateProductCategories(ProductCategories productCategories);

    ProductCategories getProductCategoriesById(Long productCategoriesId);

    List<ProductCategories> getProductCategoriesByNameOrSubCatName(String categoryName, String subCatName);

    List<ProductCategories> getAllProductCategories();

}
