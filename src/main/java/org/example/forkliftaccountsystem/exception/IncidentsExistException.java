package org.example.forkliftaccountsystem.exception;

import java.io.Serial;

public class IncidentsExistException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1030479219430434875L;

    public IncidentsExistException() {
    }

    public IncidentsExistException(Throwable cause) {
        super(cause);
    }

    public IncidentsExistException(String message) {
        super(message);
    }

    public IncidentsExistException(String message, Throwable cause) {
        super(message, cause);
    }

}
