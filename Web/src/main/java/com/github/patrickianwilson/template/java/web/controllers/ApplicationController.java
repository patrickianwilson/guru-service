package com.github.patrickianwilson.template.java.web.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.github.patrickianwilson.template.java.web.controllers.models.Application;

/**
 * Created by pwilson on 4/5/16.
 */
@Path("/application")
public class ApplicationController {


    /**
     * return a list of all applications configured in the system.  Application is synonymous with a "project" in App Engine.
     * @responseType java.util.List<com.github.patrickianwilson.template.java.web.controllers.models.Application> a list of all applications
     * @return a list of all applications
     */
    @GET
    public List<Application> listAllApplications() {
        return new ArrayList<>();
    }

    @Path("/{appId}")
    @GET
    public Application getApplicationById(@PathParam("appId") String appId) {
        return new Application();
    }

    @POST
    @Consumes("application/json")
    public Response createApplication(Application app) throws URISyntaxException {
        return Response.created(new URI("/application/")).build();
    }

}
