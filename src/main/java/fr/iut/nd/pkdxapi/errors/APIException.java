package fr.iut.nd.pkdxapi.errors;


import org.springframework.http.HttpStatus;

public abstract class APIException extends RuntimeException {
    private final HttpStatus status;
    
    public APIException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}