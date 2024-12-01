package com.eshop.productservice.service;

import com.eshop.productservice.dao.ProductPriceRepository;
import com.eshop.productservice.dao.ProductRepository;
import com.eshop.productservice.entity.ProductPrice;
import com.eshop.productservice.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {


    private final ProductPriceRepository productPriceRepository;

    private final ProductRepository productRepository;

    private final ProductService productService;

    @Override
    public ProductPrice createProductPrice(ProductPrice productPrice, String userId) {

        productPrice.setPriceId(null);
        productPrice.setStatus(true);
        if(!productRepository.existsByProductIdAndProductStatus(productPrice.getProductId(), productPrice.getStatus()))
            throw new ResourceNotFoundException("Product", "id", productPrice.getProductId().toString());

        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice updateProductPrice(ProductPrice productPrice, String userId) {
        if(!productService.existsProductIdAndShopId(productPrice.getProductId(),userId))
            throw new ResourceNotFoundException("Product", "id", productPrice.getProductId().toString());

        if(!productRepository.existsByProductIdAndProductStatus(productPrice.getProductId(), productPrice.getStatus()))
            throw new ResourceNotFoundException("Product is deactivated or", "product id", productPrice.getProductId().toString());

        ProductPrice productPrice1 = productPriceRepository.findByPriceId(productPrice.getPriceId()).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", productPrice.getProductId().toString())
        );

        productPrice1.setProductId(productPrice.getProductId());
        productPrice1.setStatus(productPrice.getStatus());
        productPrice1.setDiscount(productPrice.getDiscount());
        productPrice1.setPrice(productPrice.getPrice());
        productPrice1.setQuantityAvailable(productPrice.getQuantityAvailable());
        productPrice1.setUnitOf(productPrice.getUnitOf());
        return productPriceRepository.save(productPrice1);
    }

    @Override
    public ProductPrice getProductPrice(Long priceId) {
        return productPriceRepository.findByPriceId(priceId).orElseThrow(
                ()-> new ResourceNotFoundException("Product", "id", priceId.toString())
        );
    }

    @Override
    public List<ProductPrice> getAllProductPriceByProductId(Long productId) {
        return productPriceRepository.findByProductId(productId);
    }


}
