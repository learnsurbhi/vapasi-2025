package com.tw.util;

public class InvalidBookException extends RuntimeException {
    public InvalidBookException(String message) {
        super(message);
    }

    public InvalidBookException() {
    }
}
