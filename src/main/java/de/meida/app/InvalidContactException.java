package de.meida.app;

public class InvalidContactException extends RuntimeException {

    public InvalidContactException(String message) {
        super(message);
    }

    public InvalidContactException(String message, Throwable cause) {
        super(message, cause);
    }
}
