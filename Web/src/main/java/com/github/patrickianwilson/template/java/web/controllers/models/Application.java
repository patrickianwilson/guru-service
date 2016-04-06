package com.github.patrickianwilson.template.java.web.controllers.models;

/**
 * An Application descriptor json object.
 */
public class Application {
    /**
     *  The unique id of this application
     *  @requiredParam id
     */
    private String id;

    /**
     * A human readable name for the application.
     * @requiredParam name
     */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
