package com.developersview.springbootblogapprestapi.payload;

import java.util.Date;

/**
 * @author pranoy.chakraborty
 * @Date 29/06/2023
 */
public class ErrorDetails {
    public Date timestamp;
    public String message;
    public String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}