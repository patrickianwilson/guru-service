package com.github.patrickianwilson.template.java.web.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.github.patrickianwilson.template.java.web.controllers.models.AppVersion;
import com.github.patrickianwilson.template.java.web.controllers.models.Application;

/**
 * Created by pwilson on 4/5/16.
 */
@Path("/application/{appId}/version")
public class VersionController {

    @GET
    public List<AppVersion> listVersions(@PathParam("appId") String appId) {
        return new ArrayList<>();
    }

    @GET
    @Path("/{versionId}")
    public AppVersion getVersion(String appId, String versionId) {
        return new AppVersion();
    }


    @POST
    public Response createImmutableVersion(AppVersion version, @PathParam("appId") String appId) throws URISyntaxException {
        return Response
                .created(new URI(String.format("/application/%s/version/%s", appId, UUID.randomUUID().toString())))
                .build();
    }


}
