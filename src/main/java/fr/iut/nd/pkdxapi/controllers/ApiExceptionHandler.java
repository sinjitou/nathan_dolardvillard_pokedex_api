package fr.iut.nd.pkdxapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.iut.nd.pkdxapi.errors.APIException;
import fr.iut.nd.pkdxapi.errors.UserAlreadyExistException;

import org.springframework.http.HttpHeaders;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { APIException.class })
    protected ResponseEntity<Object> handleApiException(APIException ex, WebRequest request) {
	return handleExceptionInternal(
        ex,  
        ex.getMessage(), 
        new HttpHeaders(), 
        ex.getStatus(), 
        request
    );

}
}
