package com.github.patrickianwilson.template.java.web;

import com.google.appengine.labs.repackaged.com.google.common.collect.ImmutableMap;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * Created by pwilson on 3/7/16.
 */
public class WebModule extends ServletModule {

    @Override
    protected void configureServlets() {
        super.configureServlets();

        serve("/*").with(GuiceContainer.class, ImmutableMap.of(ResourceConfig.FEATURE_DISABLE_WADL, "true"));
    }
}
