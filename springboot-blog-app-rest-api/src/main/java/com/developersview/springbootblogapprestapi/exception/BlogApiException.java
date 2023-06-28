package com.developersview.springbootblogapprestapi.exception;

import org.springframework.http.HttpStatus;

/**
 * @author pranoy.chakraborty
 * @Date 29/06/2023
 */
public class BlogApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public BlogApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BlogApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
}
