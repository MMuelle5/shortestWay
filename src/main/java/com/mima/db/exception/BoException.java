package com.mima.db.exception;

public class BoException extends Exception {
    /**
     * @param message Fehlerbeschreibung
     */
    public BoException(String message) {
        super(message);
    }

    /**
     * @param cause Grund der Fehlermeldung
     */
    public BoException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message Fehlerbeschreibung
     * @param cause Grund der Fehlermeldung
     */
    public BoException(String message, Throwable cause) {
        super(message, cause);
    }
}
