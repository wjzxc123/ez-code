package com.licon.admin.core.exception;

public abstract class BusinessException extends Exception{
    public BusinessException(String message) {
        super(message);
    }
}
