package com.myreflectionthoughts.secmo.exception;

public class ServiceException extends RuntimeException{

    private int statusCode;
    private String errKey;

    public ServiceException(int statusCode, String errKey, String message){
        super(message);
        this.statusCode = statusCode;
        this.errKey = errKey;
    }

}
