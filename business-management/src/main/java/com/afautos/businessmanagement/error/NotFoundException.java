package com.afautos.businessmanagement.error;

public class NotFoundException extends RuntimeException{
    
    public NotFoundException(String message) {
        super(message);
    }
}
