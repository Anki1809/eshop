package com.eshop.productservice.service;

import com.eshop.productservice.dao.ProductCategoriesRepository;
import com.eshop.productservice.entity.ProductCategories;
import com.eshop.productservice.exceptions.ResourceAlreadyExistException;
import com.eshop.productservice.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoriesRepository productCategoriesRepository;
    /**
     * @param productCategories
     * @return
     */
    @Override
    public ProductCategories addProductCategories(ProductCategories productCategories) {
        productCategories.setProductCategoryId(null);
        if(productCategoriesRepository.existsByName(productCategories.getSubName())){
            throw new ResourceAlreadyExistException(
                    "Product Category", "category sub name", productCategories.getName()
            );
        }
        return productCategoriesRepository.save(productCategories);
    }

    /**
     * @param productCategories
     * @return
     */
    @Override
    public ProductCategories updateProductCategories(ProductCategories productCategories) {
        if (productCategoriesRepository.existsByName(productCategories.getSubName())) {
            throw new ResourceAlreadyExistException(
                    "Product Category", "category sub name", productCategories.getName()
            );
        }
        if (!productCategoriesRepository.existsByProductCategoryId(productCategories.getProductCategoryId())){
            throw new ResourceNotFoundException("Product Category", "id", productCategories.getProductCategoryId().toString());
        }
        return productCategoriesRepository.save(productCategories);
    }

    /**
     * @param productCategoriesId
     * @return
     */
    @Override
    public ProductCategories getProductCategoriesById(Long productCategoriesId) {
        return productCategoriesRepository.findById(productCategoriesId).
                orElseThrow(()-> new ResourceNotFoundException("Product Category", "id", productCategoriesId.toString()));
    }

    /**
     * @param categoryName
     * @param subCatName
     * @return
     */
    @Override
    public List<ProductCategories> getProductCategoriesByNameOrSubCatName(String categoryName, String subCatName) {
        return productCategoriesRepository.findByNameIgnoreCaseAndSubNameIgnoreCase(categoryName, subCatName);
    }

    /**
     * @return
     */
    @Override
    public List<ProductCategories> getAllProductCategories() {
        return productCategoriesRepository.findAll();
    }
}
