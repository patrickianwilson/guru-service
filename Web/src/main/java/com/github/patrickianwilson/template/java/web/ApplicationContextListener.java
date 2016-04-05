package com.github.patrickianwilson.template.java.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by pwilson on 3/7/16.
 */
public class ApplicationContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(Stage.DEVELOPMENT, new WebModule());
    }

}
