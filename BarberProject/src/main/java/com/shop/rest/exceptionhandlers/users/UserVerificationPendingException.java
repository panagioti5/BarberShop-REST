package com.shop.rest.exceptionhandlers.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.LOCKED)
public class UserVerificationPendingException extends RuntimeException {

    public UserVerificationPendingException(String message) {
        super(message);
    }
}
