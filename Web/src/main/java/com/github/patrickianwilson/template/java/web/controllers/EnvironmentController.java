package com.github.patrickianwilson.template.java.web.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.github.patrickianwilson.template.java.web.controllers.models.AppEnvironment;

/**
 * Created by pwilson on 4/5/16.
 */
@Path("/application/{appId}/environment")
public class EnvironmentController {

    @GET
    public List<AppEnvironment> listAllEnvironmentConfigurations(@PathParam("appId") String appId) {
        return new ArrayList<>();
    }

    @GET
    @Path("/{envId}")
    public AppEnvironment getApplicationEnvironmentConfiguration(@PathParam("appId") String appId, @PathParam("envId") String envId) {
        return new AppEnvironment();
    }

    @POST
    @Consumes("application/json")
    public Response updateEnvironment(AppEnvironment env, @PathParam("appId") String appId) throws URISyntaxException {
        return Response
                .created(new URI(String.format("/application/%s/environment/%s", appId, UUID.randomUUID().toString())))
                .build();
    }



}
