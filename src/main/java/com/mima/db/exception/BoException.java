package com.mima.db.exception;

/**
 * Business-Object Error-Klasse
 * Alle Errors des BO-Layers sollten zu einem Solchen gecastet werden
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
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
