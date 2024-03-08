package fr.iut.nd.pkdxapi.errors;

import org.springframework.http.HttpStatus;

public class TrainerAlreadyExist extends APIException {
    public TrainerAlreadyExist(String message) {
        super(HttpStatus.CONFLICT, message); 
    }
}