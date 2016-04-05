package com.github.patrickianwilson.template.java.web.repositories.exceptions;

/**
 * Created by pwilson on 3/7/16.
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
