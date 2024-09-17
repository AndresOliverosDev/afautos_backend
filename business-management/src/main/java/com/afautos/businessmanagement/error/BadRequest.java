package com.afautos.businessmanagement.error;

public class BadRequest extends RuntimeException {
    public BadRequest(String message) {
        super(message);
    }
}
