package com.eshop.shopservice.controller;


import com.eshop.shopservice.constant.ShopConstants;
import com.eshop.shopservice.dto.ErrorResponseDto;
import com.eshop.shopservice.dto.ResponseDto;
import com.eshop.shopservice.dto.ShopDto;
import com.eshop.shopservice.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Shop API",
        description = "All shop service api"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new shop."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED",
                    content = @Content(
                        schema = @Schema(implementation = ShopDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping("/add")
    public ResponseEntity<ShopDto> createCustomer(@Valid @RequestBody ShopDto shopDto) {
        return new ResponseEntity<>(shopService.addShop(shopDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "update Account REST API",
            description = "REST API to update shop details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = ShopDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ShopDto>  updateShop(@Valid @RequestBody ShopDto shopDto){
        return new ResponseEntity<>(shopService.updateShop(shopDto), HttpStatus.OK);
    }

    @Operation(
            summary = "Fetch Account REST API",
            description = "REST API to fetch shop by id."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = ShopDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/{shopId}")
    public ResponseEntity<ShopDto>  getShopById(@PathVariable Long shopId){
        return new ResponseEntity<>(shopService.getShopById(shopId), HttpStatus.OK);
    }

    @Operation(
            summary = "Fetch all Account REST API",
            description = "REST API to fetch all shop by active status."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(implementation = ShopDto.class)
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
    })
    @GetMapping("/all/{active}")
    public ResponseEntity<List<ShopDto>>  getShops(@PathVariable
                                                       @Pattern(regexp = "active|deactivate"
                                                       ,message = "Enter valid value active or deactivate")
                                                       String active){
        return new ResponseEntity<>(shopService.getShops(active.equalsIgnoreCase("active")), HttpStatus.OK);
    }

    @Operation(
            summary = "Fetch Account REST API",
            description = "REST API to fetch shop by owner id."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = ShopDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/me/{ownerId}")
    public ResponseEntity<ShopDto>  getShopByOwnerId(@PathVariable Long ownerId){
        return new ResponseEntity<>(shopService.getShopByOwnerId(ownerId), HttpStatus.OK);
    }

    @Operation(
            summary = "update Account REST API",
            description = "REST API to change active shop status."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = ShopDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/{shopId}/{active}")
    public ResponseEntity<ResponseDto> deactivateShop(@PathVariable
                                                      @Pattern(regexp = "active|deactivate"
                                                              ,message = "Enter valid value active or deactivate")
                                                      String active,
                                                      @PathVariable Long shopId){

        shopService.deactivateShop(active.equalsIgnoreCase("active"),shopId);
        return new ResponseEntity<>(new ResponseDto(ShopConstants.STATUS_200,ShopConstants.MESSAGE_200),HttpStatus.OK);
    }


}
