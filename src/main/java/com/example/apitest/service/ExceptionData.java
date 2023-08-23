package com.example.apitest.service;

public class ExceptionData extends RuntimeException {
    public ExceptionData(String message) {
        super(message);
    }

    public ExceptionData(String message, Throwable cause) {
        super(message, cause);
    }
}
