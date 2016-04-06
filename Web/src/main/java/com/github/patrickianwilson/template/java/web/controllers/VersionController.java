package com.github.patrickianwilson.template.java.web.controllers;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import com.github.patrickianwilson.template.java.web.controllers.models.Application;

/**
 * Created by pwilson on 4/5/16.
 */
@Path("/application/{appId}/version")
public class VersionController {

    public List<Application> listVersions() {
        return new ArrayList<>();
    }
}
