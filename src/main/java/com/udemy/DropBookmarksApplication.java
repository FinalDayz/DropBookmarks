package com.udemy;

import com.udemy.core.User;
import com.udemy.model.Message;
import com.udemy.persistence.ExperimentDAO;
import com.udemy.persistence.ExperimentDetailsDAO;
import com.udemy.resources.AccountResource;
import com.udemy.resources.ExperimentDetailsResource;
import com.udemy.resources.ExperimentResource;
import com.udemy.resources.MessageResource;
import com.udemy.service.AccountService;
import com.udemy.service.ExperimentDetailsService;
import com.udemy.service.ExperimentService;
import com.udemy.service.MessageService;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Stefan
 */
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
        bootstrap.addBundle(new MigrationsBundle<DropBookmarksConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(DropBookmarksConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(
            final DropBookmarksConfiguration configuration,
            final Environment environment
    ) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        environment.jersey().register(
                new ExperimentResource(new ExperimentService(jdbi))
        );
        environment.jersey().register(
                new AccountResource(new AccountService(jdbi))
        );
        environment.jersey().register(
                new ExperimentDetailsResource(new ExperimentDetailsService(jdbi))
        );
        environment.jersey().register(
                new MessageResource(new MessageService(jdbi))
        );

        environment.jersey().register(new JsonProcessingExceptionMapper(true));

    }

}
