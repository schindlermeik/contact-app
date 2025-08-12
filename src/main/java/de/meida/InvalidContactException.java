package de.meida;

public class InvalidContactException extends RuntimeException {

    public InvalidContactException(String message) {
        super(message);
    }

    public InvalidContactException(String message, Throwable cause) {
        super(message, cause);
    }
}
