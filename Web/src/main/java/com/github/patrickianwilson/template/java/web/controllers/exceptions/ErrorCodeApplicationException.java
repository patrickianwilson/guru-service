package com.github.patrickianwilson.template.java.web.controllers.exceptions;

import java.util.Map;
import javax.ws.rs.core.Response;
import org.apache.http.HttpStatus;
import com.google.common.collect.ImmutableMap;

/**
 * Created by pwilson on 3/7/16.
 */
public abstract class ErrorCodeApplicationException {

    final private Body body;

    public ErrorCodeApplicationException(Response.Status status) {
        if (defaultErrorBodies.containsKey(status)) {
            body = defaultErrorBodies.get(status);
        } else if (defaultFamilyErrorBodies.containsKey(status.getFamily())) {
            body = defaultFamilyErrorBodies.get(status.getFamily());
        } else {
            body = null;
        }
    }

    public ErrorCodeApplicationException(Response.Status status, String code, String message) {
        body = new Body(message, code);
    }

    public static class Body {

        private String message;
        private String code;

        private Body(String message, String code) {
            this.message = message;
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    /*
    TODO - the outter class should be pulled into a java web shared library and these defaults should be configurable.
     */
    private Map<Response.Status, Body> defaultErrorBodies = ImmutableMap.<Response.Status, Body>builder()
            .put(Response.Status.UNAUTHORIZED, new Body("The request requiest authentication but no Authentication header was provided.", "http-no-auth"))
            .build();

    private Map<Response.Status.Family, Body> defaultFamilyErrorBodies = ImmutableMap.<Response.Status.Family, Body>builder()
            .put(Response.Status.Family.CLIENT_ERROR, new Body("This request was malformed", "http-bad-request"))
            .put(Response.Status.Family.SERVER_ERROR, new Body("The request was interrupted by an unknown error, please try again later", "http-serv-error"))
            .build();
}
