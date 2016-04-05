package com.github.patrickianwilson.template.java.web.repositories.exceptions;

/**
 * Created by pwilson on 3/7/16.
 */
public class DatabaseException extends RuntimeException {
    public DatabaseException() {
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
