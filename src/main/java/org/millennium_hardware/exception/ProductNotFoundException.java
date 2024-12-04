package org.millennium_hardware.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String massage) {
        super(massage);
    }
}
