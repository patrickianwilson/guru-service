package com.github.patrickianwilson.template.java.web.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.github.patrickianwilson.template.java.web.controllers.models.User;

/**
 * Created by pwilson on 3/7/16.
 */
@Path("/users")
public class UserResourceController {

    /**
     * find all users (filtered by the provided query params.
     * @param email
     * @param fname
     * @return
     */
    @GET
    public List<User> searchUsers(@QueryParam("email") String email, @QueryParam("fname") String fname) {
        return new ArrayList<User>();
    }

    @GET
    public Response registerUser(User candidate) {

        return null;
    }

    @GET
    @Path("/{id}")
    public Response findUserById(@PathParam("id") String id) {
        return null;
    }
}
