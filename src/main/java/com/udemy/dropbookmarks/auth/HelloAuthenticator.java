package com.udemy.dropbookmarks.auth;

import com.google.common.base.Optional;
import com.udemy.core.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class HelloAuthenticator implements Authenticator<BasicCredentials, User> {
    @Override
    public Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        if(basicCredentials.getPassword().equals("password")) {
            return Optional.of(new User());
        }
        return Optional.absent();
    }
}
