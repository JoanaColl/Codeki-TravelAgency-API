package com.codeki.travelagency.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class NullPointerException extends RuntimeException {
    public NullPointerException(String message){
        super(message);
    }
}