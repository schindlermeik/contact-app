package de.meida.app;

public class ContactNotSaveException extends RuntimeException {
    public ContactNotSaveException(String message) {
        super(message);
    }
    public ContactNotSaveException(String message, Throwable cause){
        super(message, cause);
    }
}
