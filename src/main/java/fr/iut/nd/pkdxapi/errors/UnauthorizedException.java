package fr.iut.nd.pkdxapi.errors;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends APIException {
    public UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message); 
    }
}