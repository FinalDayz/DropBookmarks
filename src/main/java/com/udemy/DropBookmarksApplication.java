package com.udemy;

import com.udemy.core.User;
import com.udemy.dropbookmarks.auth.HelloAuthenticator;
import com.udemy.model.Experiment;
import com.udemy.persistence.ExperimentDAO;
import com.udemy.resources.ExperimentResource;
import com.udemy.service.ExperimentService;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import ru.vyarus.dropwizard.guice.GuiceBundle;

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
//        bootstrap.addBundle(new MigrationsBundle<DropBookmarksConfiguration>() {
//            @Override
//            public DataSourceFactory getDataSourceFactory(DropBookmarksConfiguration configuration) {
//                return configuration.getDataSourceFactory();
//            }
//        });
    }

    @Override
    public void run(
            final DropBookmarksConfiguration configuration,
            final Environment environment
    ) {

        JdbiFactory factory = new JdbiFactory();
       // System.out.println(configuration.getDataSourceFactory());
        Jdbi jdbi = null;//factory.build(environment, configuration.getDataSourceFactory(), "mysql");

        environment.jersey().register(
                new ExperimentResource(new ExperimentService(new ExperimentDAO(jdbi)))
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
