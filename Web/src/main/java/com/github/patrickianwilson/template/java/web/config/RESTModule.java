package com.github.patrickianwilson.template.java.web.config;

import com.github.patrickianwilson.template.java.web.UserService;
import com.github.patrickianwilson.template.java.web.config.writers.InputStreamWriter;
import com.github.patrickianwilson.template.java.web.config.writers.JsonStreamReaderWriter;
import com.github.patrickianwilson.template.java.web.controllers.UserResourceController;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;
import com.google.common.collect.ImmutableMap;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * Created by pwilson on 2/18/16.
 */
public class RESTModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {
        super.configureServlets();

        //housecleaning controllers
//        bind(HealthController.class);
//        bind(AppEngineController.class);

//        Message writers and readers
        bind(JsonStreamReaderWriter.class);
        bind(InputStreamWriter.class);  //needed to bypass a restricted class...

        //helper services
//        bind(DataService.class);

        //REST controllers
//        bind(ResourceController.class);
//        bind(ResourceTransactionController.class);
//        bind(CategoryTreeExplorationController.class);
//        bind(PersonalizedRecommendationController.class);
//        bind(SearchController.class);
//
//        bind(SvgUploadController.class);

        //basic appengine services
        bind(DatastoreService.class).toInstance(DatastoreServiceFactory.getDatastoreService());
        bind(MemcacheService.class).toInstance(MemcacheServiceFactory.getMemcacheService());
        bind(URLFetchService.class).toInstance(URLFetchServiceFactory.getURLFetchService());
        bind(GcsService.class).toInstance(GcsServiceFactory.createGcsService(RetryParams.getDefaultInstance()));

        //bind controllers
        bind(UserResourceController.class);

        //helps
        filter("/*").through(CorsFilter.class);
        serve("/*").with(GuiceContainer.class);

    }
}
