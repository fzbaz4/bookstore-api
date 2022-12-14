package com.bookstore.api.bookstoreapi.exception;

import com.bookstore.api.bookstoreapi.entity.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ApiExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { NoSuchElementException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ExceptionMessage("No Book Found!"),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value
            = { CustomException.class })
    protected ResponseEntity<Object> handleCustomConflict(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ExceptionMessage(ex.getMessage()),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}