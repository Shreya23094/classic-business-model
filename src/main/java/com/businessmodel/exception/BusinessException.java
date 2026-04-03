package com.businessmodel.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(final String message) {
        super(message);
    }
}
