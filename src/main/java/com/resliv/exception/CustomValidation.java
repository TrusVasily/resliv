package com.resliv.exception;

public class CustomValidation extends RuntimeException {
    public CustomValidation(String message){
        super(message);
    }
}
