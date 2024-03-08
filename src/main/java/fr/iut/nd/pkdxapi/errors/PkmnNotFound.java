package fr.iut.nd.pkdxapi.errors;

import org.springframework.http.HttpStatus;

public class PkmnNotFound extends APIException {
    public PkmnNotFound(String message) {
        super(HttpStatus.NOT_FOUND, message); 
    }
}