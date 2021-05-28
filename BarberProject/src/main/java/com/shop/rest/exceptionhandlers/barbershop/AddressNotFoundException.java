package com.shop.rest.exceptionhandlers.barbershop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class AddressNotFoundException extends RuntimeException
{
    public AddressNotFoundException(String message) {
        super(message);
    }
}
