package com.bookstore.api.bookstoreapi.exception;

public class CustomException extends RuntimeException{
    public CustomException(String errorMessage) {
        super(errorMessage);
    }
}
