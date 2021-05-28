package com.shop.rest.exceptionhandlers.barbershop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class WorkersNotFoundException extends RuntimeException
{
    public WorkersNotFoundException(String message)
    {
        super(message);
    }
}
