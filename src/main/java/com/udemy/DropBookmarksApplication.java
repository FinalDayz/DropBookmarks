package com.udemy;

import com.udemy.core.User;
import com.udemy.dropbookmarks.auth.HelloAuthenticator;
import com.udemy.persistence.ExperimentDAO;
import com.udemy.resources.ExperimentResource;
import com.udemy.resources.HelloResource;
import com.udemy.service.ExperimentService;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropBookmarksApplication extends Application<DropBookmarksConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropBookmarksApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropBookmarks";
    }

    @Override
    public void initialize(final Bootstrap<DropBookmarksConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropBookmarksConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(
                new ExperimentResource(new ExperimentService(new ExperimentDAO()))
        );
        environment.jersey().register(
                AuthFactory.binder(
                        new BasicAuthFactory<>(
                                new HelloAuthenticator(),
                                "SECURITY REALM",
                                User.class
                        )
                )
        );
    }

}
