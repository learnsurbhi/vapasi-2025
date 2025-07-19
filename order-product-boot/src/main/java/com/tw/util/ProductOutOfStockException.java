package com.tw.util;

public class ProductOutOfStockException extends RuntimeException {


    public ProductOutOfStockException(String message) {
        super(message);
    }

    public ProductOutOfStockException() {
        super("Product out of stock");
    }
}
