package com.udemy;

import com.udemy.core.User;
import com.udemy.dropbookmarks.auth.HelloAuthenticator;
import com.udemy.persistence.ExperimentDAO;
import com.udemy.persistence.ExperimentDetailsDAO;
import com.udemy.resources.AccountResource;
import com.udemy.resources.ExperimentDetailsResource;
import com.udemy.resources.ExperimentResource;
import com.udemy.service.AccountService;
import com.udemy.service.ExperimentDetailsService;
import com.udemy.service.ExperimentService;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DropBookmarksApplication extends Application<DropBookmarksConfiguration> {

//    private final HibernateBundle<DropBookmarksConfiguration> hibernateBundle =
//            new HibernateBundle<DropBookmarksConfiguration>(DataSourceFactory.class) {
//                @Override
//                public DataSourceFactory getDataSourceFactory(DropBookmarksConfiguration configuration) {
//                    return configuration.getDataSourceFactory();
//                }
//            };


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
                new ExperimentDetailsResource(new ExperimentDetailsService(new ExperimentDetailsDAO()))
        );


//        environment.jersey().register(
//                AuthFactory.binder(
//                        new BasicAuthFactory<>(
//                                new HelloAuthenticator(),
//                                "SECURITY REALM",
//                                User.class
//                        )
//                )
//        );
    }

}
