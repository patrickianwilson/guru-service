package com.github.patrickianwilson.template.java.web.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.github.patrickianwilson.template.java.web.controllers.models.DeploymentProgress;

/**
 * Manages a logical "stack" of deployments in an application.
 *
 * This controller is responsible for managing deployments in an application.  It uses previously
 * created environment configs and versions and manages their pairing in the deploy of the actual running system.
 *
 * The controller also maintains a stack of deployments.  Calling DELETE will POP an item off the stack and POST will put a new
 * item on the stack.
 */
@Path("/application/{appId}/reality")
public class DeploymentController {

    /**
     * Add a new deployment to the "stack" of deployments.
     * @return
     */
    @POST
    public Response deployLatestVersionAndConfig(@PathParam("appId") String appId) throws URISyntaxException {
        return Response
                .created(new URI(String.format("/application/%s/reality/%s", appId, UUID.randomUUID().toString())))
                .build();
    }

    /**
     *
     * @return
     */
    @DELETE
    public Response rollbackToPrevious() {
        return Response.noContent().build();
    }


    @GET
    @Path("/{statusId}")
    public DeploymentProgress getStatusUpdate(@PathParam("appId") String appId, @PathParam("statusId") String statusId) {
        return new DeploymentProgress();
    }



}
