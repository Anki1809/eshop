package com.eshop.shopservice.exceptions;

public class ShopAlreadyExistException extends RuntimeException {
    public ShopAlreadyExistException(String message) {
        super(message);
    }
}
