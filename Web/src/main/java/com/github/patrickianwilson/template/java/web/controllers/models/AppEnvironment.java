package com.github.patrickianwilson.template.java.web.controllers.models;

import java.util.Map;

/**
 * Created by pwilson on 4/5/16.
 */
public class AppEnvironment {
    private Map<String, String> config;
    private String versionId;

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}
