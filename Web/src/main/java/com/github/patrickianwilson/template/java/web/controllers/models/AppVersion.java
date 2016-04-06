package com.github.patrickianwilson.template.java.web.controllers.models;

/**
 * Created by pwilson on 4/5/16.
 */
public class AppVersion {

    private String id;
    private String internalId;
    private String artifactLocation;
    private String environmentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public String getArtifactLocation() {
        return artifactLocation;
    }

    public void setArtifactLocation(String artifactLocation) {
        this.artifactLocation = artifactLocation;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
    }
}
