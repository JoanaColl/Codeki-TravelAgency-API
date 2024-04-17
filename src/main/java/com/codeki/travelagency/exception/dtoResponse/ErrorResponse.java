package com.codeki.travelagency.exception.dtoResponse;

public class ErrorResponse {
    private int statusCode;
    private String message;


    // -----------  COMPLETE CONSTRUCTOR  ------------
    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }


    // ---------  GETTER AND SETTER METHODS  ---------
    public ErrorResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}