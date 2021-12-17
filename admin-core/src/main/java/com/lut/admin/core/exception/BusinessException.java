package com.lut.admin.core.exception;

public abstract class BusinessException extends Exception{
    public BusinessException(String message) {
        super(message);
    }
}
