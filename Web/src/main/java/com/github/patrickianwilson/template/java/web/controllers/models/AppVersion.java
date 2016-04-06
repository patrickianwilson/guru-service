package com.github.patrickianwilson.template.java.web.controllers.models;

/**
 * Created by pwilson on 4/5/16.
 */
public class AppVersion {

    /**
     * The identifier for this version.  Unique within an application.
     * @requiredParam
     */
    private String id;

    /**
     * A pointer to an artifact that has been uploaded to a CDN.
     * @requiredParam
     */
    private String artifactLocation;


    /**
     * A reference to the environment configuration to use with this deployment.  This is required for ]
     * immutable and repeatable deployments.
     * If not specified this will default to the latest environment.
     */
    private String environmentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
