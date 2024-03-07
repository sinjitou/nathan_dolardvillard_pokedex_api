package fr.iut.nd.pkdxapi.errors;

import org.springframework.http.HttpStatus;

public class UserNotFound extends APIException {
    public UserNotFound(String message) {
        super(HttpStatus.NOT_FOUND, message); 
    }
}