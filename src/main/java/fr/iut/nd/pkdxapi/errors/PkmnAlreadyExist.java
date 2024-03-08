package fr.iut.nd.pkdxapi.errors;

import org.springframework.http.HttpStatus;

public class PkmnAlreadyExist extends APIException {
    public PkmnAlreadyExist(String message) {
        super(HttpStatus.CONFLICT, message); 
    }
}