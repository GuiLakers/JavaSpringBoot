package com.cadastrocliente.exceptions;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ErrorValidationHandler404 extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
        
        String errorMessageDescription= ex.getLocalizedMessage();
        
        if (errorMessageDescription== null) errorMessageDescription= ex.toString();
            
        
        
        ErrorMessage404 errorMessage= new ErrorMessage404(new Date(), ex.getLocalizedMessage());
        
        
        return new ResponseEntity<>(errorMessage, new HttpHeaders(),HttpStatus.NOT_FOUND);
    
    
    }
}