package com.udemy.dropbookmarks.auth;

import com.google.common.base.Optional;
import com.udemy.core.User;
import com.udemy.model.Account;
import com.udemy.persistence.AccountDAO;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import org.skife.jdbi.v2.DBI;

import javax.inject.Inject;
/**
 * @author Stefan
 */
public class BasicAuthenticator implements Authenticator<BasicCredentials, Account> {

    private final AccountDAO dao;

    private final DBI database;

    @Inject
    public BasicAuthenticator(DBI jdbi) {
        this.database = jdbi;
        dao = this.database.onDemand(AccountDAO.class);
    }

    /**
     * Checks whether given password and username are correct
     * @param basicCredentials
     * @return
     */
    @Override
    public Optional<Account> authenticate(BasicCredentials basicCredentials) {
        if(dao.isValidLogin(basicCredentials.getUsername(), basicCredentials.getPassword()) != 1) {
            return Optional.absent();
        }
        return Optional.of(dao.findAccount(basicCredentials.getUsername(), basicCredentials.getPassword()));
    }
}
