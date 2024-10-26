package com.eshop.shopservice.exceptions;

public class NotAResourceOwnerException extends RuntimeException {
    public NotAResourceOwnerException(String message) {
        super(message);
    }
}
