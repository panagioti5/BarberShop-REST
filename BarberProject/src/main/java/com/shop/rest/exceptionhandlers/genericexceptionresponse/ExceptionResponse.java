package com.shop.rest.exceptionhandlers.genericexceptionresponse;

import com.shop.rest.constants.APIResponseCodes;

import java.util.Date;

public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;
    private APIResponseCodes status;

    public ExceptionResponse(Date timestamp, String message, String details, APIResponseCodes status) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public APIResponseCodes getStatus() {
        return status;
    }

    public void setStatus(APIResponseCodes status) {
        this.status = status;
    }

}
