package com.eshop.productservice.controller;


import com.eshop.productservice.dto.ErrorResponseDto;
import com.eshop.productservice.entity.ProductCategories;
import com.eshop.productservice.service.ProductCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@Tag(
        name = "Product Category API",
        description = "product service api"
)*/
@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/api/category")
public class ProductCatController {

    private final ProductCategoryService productCategoryService;

    /*@Operation(
            summary = "Create Product Category"
            //description = ""
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED",
                    content = @Content(
                            schema = @Schema(implementation = ProductCategories.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })*/
    @PostMapping("/add")
    public ResponseEntity<ProductCategories> addProductCategories(@Valid @RequestBody ProductCategories productCategories) {
        return new ResponseEntity<>(productCategoryService.addProductCategories(productCategories), HttpStatus.CREATED);
    }

   /* @Operation(
            summary = "Update Product Category"
            //description = ""
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = ProductCategories.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })*/
    @PutMapping("/update")
    public ResponseEntity<ProductCategories> updateProductCategories(@Valid @RequestBody ProductCategories productCategories) {
        return new ResponseEntity<>(productCategoryService.updateProductCategories(productCategories), HttpStatus.OK);
    }

   /* @Operation(
            summary = "Get Product Category by id"
            //description = ""
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = ProductCategories.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })*/
    @GetMapping("/find/{id}")
    public ResponseEntity<ProductCategories> getProductCategoriesById(@PathVariable(name = "id") @Positive(message = "Enter valid product category id.") Long productCategoriesId) {
        return new ResponseEntity<>(productCategoryService.getProductCategoriesById(productCategoriesId), HttpStatus.OK);
    }

    /*@Operation(
            summary = "Find by Product Category and sub-category"
            //description = ""
    )*/
    /*@ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(implementation = ProductCategories.class)
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })*/
    @GetMapping("/find")
    public ResponseEntity<List<ProductCategories>>
        getProductCategoriesByNameOrSubCatName(@RequestParam(name = "category") String categoryName,
                                               @RequestParam(name = "subcategory") String subCatName) {
        return new ResponseEntity<>(productCategoryService.getProductCategoriesByNameOrSubCatName(categoryName, subCatName), HttpStatus.OK);
    }

    /*@Operation(
            summary = "Get all Product Category"
            //description = ""
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            array = @ArraySchema(
                                schema = @Schema(implementation = ProductCategories.class)
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })*/
    @GetMapping("/all")
    public ResponseEntity<List<ProductCategories>> getAllProductCategories() {
        return new ResponseEntity<>(productCategoryService.getAllProductCategories(), HttpStatus.OK);
    }
}
