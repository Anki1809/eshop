package com.eshop.productservice.controller;

import com.eshop.productservice.audit.AuditAwareImpl;
import com.eshop.productservice.dto.ProductRequest;
import com.eshop.productservice.dto.ProductResponse;
import com.eshop.productservice.dto.ResponseDto;
import com.eshop.productservice.entity.ProductPrice;
import com.eshop.productservice.service.ProductPriceService;
import com.eshop.productservice.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Validated
public class ProductController {

    private final ProductService productService;
    private final ProductPriceService productPriceService;
    private final AuditAwareImpl auditAware;

    public ProductController(ProductService productService, ProductPriceService productPriceService, AuditAwareImpl auditAware) {
        this.productService = productService;
        this.productPriceService = productPriceService;
        this.auditAware = auditAware;
    }

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addProduct(@Valid @RequestBody ProductRequest productRequest
            ,@RequestHeader("X-User-Id") String userId) {
        try {
            auditAware.setCurrentAuditor(userId);
        return new ResponseEntity<>(productService.addProduct(productRequest,userId), HttpStatus.CREATED);
        }
        finally {
            auditAware.clear();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ProductResponse> updateProduct(@Valid @RequestBody ProductRequest productRequest
            ,@RequestHeader("X-User-Id") String userId) {
            try {
                auditAware.setCurrentAuditor(userId);
        return new ResponseEntity<>(productService.updateProduct(productRequest, userId), HttpStatus.OK);
            }
            finally {
                auditAware.clear();
            }
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<ResponseDto> productStatus(@PathVariable(name = "id") Long productId, @PathVariable String status
                    ,@RequestHeader("X-User-Id") String userId) {
        Boolean flag = productService.productStatus(productId,status.equalsIgnoreCase("active"),userId);

                try {
                    auditAware.setCurrentAuditor(userId);
        return new ResponseEntity<>( new ResponseDto(flag? "OK": "BAD_REQUEST"
                ,flag? "Status updated.":"Status update failed please try again.")
                , flag? HttpStatus.OK:HttpStatus.BAD_REQUEST
        );
                }
                finally {
                    auditAware.clear();
                }
    }

    @GetMapping("/get/all/{status}")
    public ResponseEntity<List<ProductResponse>> getAllProducts(@PathVariable @Pattern(regexp = "active|deactivated", message = "Enter any one value active or deactivated.") String status) {
        return new ResponseEntity<>(productService.getAllProducts(status.equalsIgnoreCase("active")), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable(name = "id") Long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PostMapping("/price/add")
    public ResponseEntity<ProductPrice> createProductPrice(@Valid @RequestBody ProductPrice productPrice
            ,@RequestHeader("X-User-Id") String userId) {
        try {
            auditAware.setCurrentAuditor(userId);
        return new ResponseEntity<>(productPriceService.createProductPrice(productPrice, userId), HttpStatus.CREATED);
        }
        finally {
            auditAware.clear();
        }
    }

    @PutMapping("/price/update")
    public ResponseEntity<ProductPrice> updateProductPrice(@Valid @RequestBody ProductPrice productPrice
            ,@RequestHeader("X-User-Id") String userId) {
                        try {
                            auditAware.setCurrentAuditor(userId);
                            return new ResponseEntity<>(productPriceService.updateProductPrice(productPrice, userId), HttpStatus.OK);
                        }
                        finally {
                            auditAware.clear();
                        }
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<ProductPrice> getProductPrice(@PathVariable(name = "id") Long priceId) {
        return new ResponseEntity<>(productPriceService.getProductPrice(priceId), HttpStatus.OK);
    }

    @GetMapping("/price/prooductid/{id}")
    public ResponseEntity<List<ProductPrice>> getAllProductPriceByProductId(@PathVariable(name = "id") Long productId) {
        return new ResponseEntity<>(productPriceService.getAllProductPriceByProductId(productId), HttpStatus.OK);
    }
}
