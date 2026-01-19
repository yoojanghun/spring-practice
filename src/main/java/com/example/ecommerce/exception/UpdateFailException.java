package com.example.ecommerce.exception;

// Throwable -> Exception -> IOException (부모 -> 자식 클래스)
public class UpdateFailException extends RuntimeException {
    public UpdateFailException(Throwable cause) {
        super("Failed to update product ", cause);
    }
}
