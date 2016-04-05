package com.github.patrickianwilson.template.java.web.controllers.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by pwilson on 3/7/16.
 */
public class UserNotFoundException extends ErrorCodeApplicationException {
    public UserNotFoundException(String id) {
        super(Response.Status.NOT_FOUND, "http-user-not-found", String.format("User with Id=%s was not found", id));
    }
}
