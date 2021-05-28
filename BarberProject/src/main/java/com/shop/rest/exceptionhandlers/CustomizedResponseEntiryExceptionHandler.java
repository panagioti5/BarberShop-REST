package com.shop.rest.exceptionhandlers;

import com.shop.rest.constants.APIResponseCodes;
import com.shop.rest.exceptionhandlers.barbershop.BarberShopNotFoundException;
import com.shop.rest.exceptionhandlers.genericexceptionresponse.ExceptionResponse;
import com.shop.rest.exceptionhandlers.users.UserAlreadyExistsException;
import com.shop.rest.exceptionhandlers.users.UserNotFoundException;
import com.shop.rest.exceptionhandlers.users.UserVerificationPendingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntiryExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BarberShopNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(BarberShopNotFoundException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), e.getMessage(), APIResponseCodes.KO);
        request.getDescription(false);

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(UserNotFoundException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), e.getMessage(), APIResponseCodes.KO);
        request.getDescription(false);
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public final ResponseEntity<Object> handleAllExceptions(UserAlreadyExistsException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), e.getMessage(), APIResponseCodes.KO);
        request.getDescription(false);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UserVerificationPendingException.class)
    public final ResponseEntity<Object> handleAllExceptions(UserVerificationPendingException e, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), e.getMessage(), APIResponseCodes.KO);
        request.getDescription(false);
        return new ResponseEntity(exceptionResponse, HttpStatus.LOCKED);

    }
}
