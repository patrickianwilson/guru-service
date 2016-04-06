package com.github.patrickianwilson.template.java.web.controllers.models;

/**
 * Created by pwilson on 4/6/16.
 */
public class DeploymentProgress {

    /**
     * The different states a deployment can possibly be in at any given time.
     * COMPLETED means successfully deployed.
     */
    public static enum Statuses {
        STARTED, ABORTED, COMPLETED
    }
    private Statuses status;

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }
}
