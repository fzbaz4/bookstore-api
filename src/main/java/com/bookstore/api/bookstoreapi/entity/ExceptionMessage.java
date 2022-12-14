package com.bookstore.api.bookstoreapi.entity;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ExceptionMessage {
    private String responseStatus;
    private String errorMessage;

    public ExceptionMessage(String errorMessage){
        this.responseStatus = String.valueOf(HttpStatus.NO_CONTENT.value());
        this.errorMessage = errorMessage;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static <T> List <T> requireNotEmpty(List<T> items){
        if (items.isEmpty()) {
            throw new NoSuchElementException();
        }
        return items;


    }
}
