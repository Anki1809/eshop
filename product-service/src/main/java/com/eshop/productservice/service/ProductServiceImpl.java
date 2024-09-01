package com.eshop.productservice.service;

import com.eshop.productservice.dao.ProductCategoriesRepository;
import com.eshop.productservice.dao.ProductPriceRepository;
import com.eshop.productservice.dao.ProductRepository;
import com.eshop.productservice.dto.ProductRequest;
import com.eshop.productservice.dto.ProductResponse;
import com.eshop.productservice.entity.Product;
import com.eshop.productservice.entity.ProductCategories;
import com.eshop.productservice.exceptions.ResourceNotFoundException;
import com.eshop.productservice.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductCategoriesRepository productCategoriesRepository;

    private final ProductPriceRepository productPriceRepository;

    /**
     * @param productRequest
     * @return
     */

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = ProductMapper.mapToProduct(productRequest, new Product());
        product.setProductId(null);
        product.setProductStatus(true);
        ProductCategories productCategories = productCategoriesRepository.
                findById(productRequest.categoryId()).orElseThrow(()->new ResourceNotFoundException(
                        "Product Category","category id",productRequest.categoryId().toString()
                ));
        return ProductMapper.mapToProductResponse(productRepository.save(product), productCategories);
    }

    /**
     * @param productRequest
     * @return
     */
    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        Product product = productRepository.findById(productRequest.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Product","product id",productRequest.productId().toString()));
        ProductMapper.mapToProduct(productRequest, product);
        ProductCategories productCategories = productCategoriesRepository.
                findById(productRequest.categoryId()).orElseThrow(()->new ResourceNotFoundException(
                        "Product Category","category id",productRequest.categoryId().toString()
                ));
        return ProductMapper.mapToProductResponse(productRepository.save(product), productCategories);
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public Boolean productStatus(Long productId, Boolean active) {
        if(!productRepository.existsByProductId(productId))
            throw new ResourceNotFoundException("Product","product id",productId.toString());
        return productRepository.updateProductStatusByProductId(active,productId)==1;
    }

    /**
     * @return
     */
    @Override
    public List<ProductResponse> getAllProducts(Boolean status) {
        return productRepository.findByProductStatus(status).stream().map(
                e -> {
                    ProductCategories productCategories = productCategoriesRepository.
                            findById(e.getCategoryId()).orElseThrow(()->new ResourceNotFoundException(
                                    "Product Category","category id",e.getCategoryId().toString()
                            ));

                    return ProductMapper.mapToProductResponse(e, productCategories);
                }
        ).toList();
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public ProductResponse getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product","product id",productId.toString())
        );
        ProductCategories productCategories = productCategoriesRepository.
                findById(product.getCategoryId()).orElseThrow(()->new ResourceNotFoundException(
                        "Product Category","category id",product.getCategoryId().toString()
                ));
        return ProductMapper.mapToProductResponse(product, productCategories);
    }

    @Override
    public List<ProductResponse> getAllProductsByShopId(Long shopId) {
        /*if(!productRepository.existsByShopId(shopId))
            throw new ResourceNotFoundException("Product","shop id",shopId.toString());*/
        return productRepository.findByShopId(shopId).stream().map(
                e -> {
                    ProductCategories productCategories = productCategoriesRepository.
                            findById(e.getCategoryId()).orElseThrow(()->new ResourceNotFoundException(
                                    "Product Category","category id",e.getCategoryId().toString()
                            ));

                    return ProductMapper.mapToProductResponse(e, productCategories);
                }
        ).toList();
    }

    @Override
    public List<ProductResponse> getAllProductsByCategoryId(Long shopId, Long categoryId) {
        ProductCategories productCategories = productCategoriesRepository.
                findById(categoryId).orElseThrow(()->new ResourceNotFoundException(
                        "Product Category","category id",categoryId.toString()
                ));
        return productRepository.findByShopIdAndCategoryId(shopId,categoryId).stream().map(
                e -> ProductMapper.mapToProductResponse(e, productCategories)
        ).toList();
    }


}
