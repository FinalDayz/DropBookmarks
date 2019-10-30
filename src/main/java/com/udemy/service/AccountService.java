package com.udemy.service;

import com.udemy.model.Account;
import com.udemy.persistence.AccountDAO;
import com.udemy.persistence.ExperimentDAO;
import org.skife.jdbi.v2.DBI;

import javax.inject.Inject;
import java.util.Collection;

public class AccountService  extends BaseService<Account>{
    private final AccountDAO dao;

    private final DBI database;
    @Inject
    public AccountService(DBI jdbi) {
        this.database = jdbi;
        dao = this.database.onDemand(AccountDAO.class);
    }

    public Collection<Account> getAll() {
        return dao.getAll();
    }

    public void add(Account account) {
        dao.add(account);
    }

    public void update(int id, Account account) {
        dao.update(id, account);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public String findRol(String name) {
        return dao.findRol(name);
    }

    public boolean isValidLogin(String name, String email) {
        return dao.isValidLogin(name, email) != 0;
    }
}
