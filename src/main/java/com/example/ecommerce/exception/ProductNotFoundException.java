package com.example.ecommerce.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id) {
        super("상품을 찾을 수 없습니다. id: " + id);
    }
}
