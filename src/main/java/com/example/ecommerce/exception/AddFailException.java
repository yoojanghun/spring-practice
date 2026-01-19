package com.example.ecommerce.exception;

public class AddFailException extends RuntimeException {
    public AddFailException(Throwable cause) {
        super("Fail to Add Product " + cause);
    }
}
