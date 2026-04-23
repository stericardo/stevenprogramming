package com.stevenprogramming.spring.rest.config;

public class ErrorResponse {

    private String errorString;

    public ErrorResponse(String errorString){
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }
}
