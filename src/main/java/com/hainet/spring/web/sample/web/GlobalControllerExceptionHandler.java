package com.hainet.spring.web.sample.web;

import com.hainet.spring.web.sample.web.exception.HttpStatus404Exception;
import com.hainet.spring.web.sample.web.exception.HttpStatus500Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpStatus404Exception.class)
    public void handle404() {
        // Nothing to do
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpStatus500Exception.class)
    public void handle500() {
        // Nothing to do
    }
}
