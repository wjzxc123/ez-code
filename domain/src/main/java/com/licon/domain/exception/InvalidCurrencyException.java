package com.licon.domain.exception;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/10/29 14:47
 */
public class InvalidCurrencyException extends IllegalArgumentException{
    public InvalidCurrencyException() {
    }

    public InvalidCurrencyException(String s) {
        super(s);
    }
}
