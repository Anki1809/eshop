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

    @Override
    public ProductPrice createProductPrice(ProductPrice productPrice) {
        productPrice.setPriceId(null);
        productPrice.setStatus(true);
        if(!productRepository.existsByProductIdAndProductStatus(productPrice.getProductId(), productPrice.getStatus()))
            throw new ResourceNotFoundException("Product", "id", productPrice.getProductId().toString());

        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice updateProductPrice(ProductPrice productPrice) {
        if(!productRepository.existsByProductIdAndProductStatus(productPrice.getProductId(), productPrice.getStatus()))
            throw new ResourceNotFoundException("Product is deactivated or", "product id", productPrice.getProductId().toString());

        if(!productPriceRepository.existsById(productPrice.getPriceId()))
            throw new ResourceNotFoundException("Price", "price id", productPrice.getPriceId().toString());

        return productPriceRepository.save(productPrice);
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
