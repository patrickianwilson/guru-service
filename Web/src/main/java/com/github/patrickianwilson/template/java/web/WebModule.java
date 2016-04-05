package com.github.patrickianwilson.template.java.web;

import org.jboss.resteasy.plugins.server.servlet.FilterDispatcher;
import com.google.inject.servlet.ServletModule;

/**
 * Created by pwilson on 3/7/16.
 */
public class WebModule extends ServletModule {

    @Override
    protected void configureServlets() {
        super.configureServlets();

        //boot up the resteasy dispatcher.
        bind(FilterDispatcher.class).asEagerSingleton();
        filter("/*").through(FilterDispatcher.class);

    }
}
