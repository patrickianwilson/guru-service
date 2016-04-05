package com.github.patrickianwilson.template.java.web.config;

/**
 * Created by pwilson on 3/9/16.
 */
public class InitializationException extends RuntimeException {
    public InitializationException(String message) {
        super(message);
    }

    public InitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
