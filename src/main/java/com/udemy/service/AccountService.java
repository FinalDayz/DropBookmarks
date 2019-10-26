package com.udemy.service;

import com.udemy.model.Account;
import com.udemy.persistence.AccountDAO;

import javax.inject.Inject;
import java.util.Collection;

public class AccountService  extends BaseService<Account>{
    private final AccountDAO dao;

    @Inject
    public AccountService(AccountDAO accountDAO) {
        this.dao = accountDAO;
    }

    public Collection<Account> getAll() {
        return dao.getAll();
    }

    public Account find(int id) {
        return requireResult(dao.find(id));
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

    public Account findName(String name) {
        return dao.findName(name);
    }

    public boolean isValidLogin(String name, String email) {
        return dao.isValidLogin(name, email);
    }
}
