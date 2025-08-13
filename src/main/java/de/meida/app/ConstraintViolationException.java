package de.meida.app;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException(String message) {
        super(message);
    }
}
