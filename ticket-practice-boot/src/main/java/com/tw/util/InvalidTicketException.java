package com.tw.util;

public class InvalidTicketException extends RuntimeException {
    public InvalidTicketException(String message) {
        super(message);
    }

    public InvalidTicketException() {
    }
}
