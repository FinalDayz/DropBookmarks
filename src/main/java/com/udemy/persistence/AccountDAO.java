package com.udemy.persistence;

import com.udemy.model.Account;
import com.udemy.model.Experiment;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    private final List<Account> accounts;

    public AccountDAO() {

        Account account1= new Account();
        account1.setAccountId(0);
        account1.setAccountNaam("Henk");
        account1.setAccountWachtwoord("password1");
        account1.setAccountRol("Gebruiker");

        Account account2= new Account();
        account2.setAccountId(1);
        account2.setAccountNaam("Stefan");
        account2.setAccountWachtwoord("w4chtw00rd!");
        account2.setAccountRol("Admin");

        Account account3 = new Account();
        account3.setAccountId(2);
        account3.setAccountNaam("Bart");
        account3.setAccountWachtwoord("123456");
        account3.setAccountRol("Medewerker");


        accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
    }

    public Account findName(String name) {
        /* EXECUTE QUERY */
        for (Account account : this.accounts) {
            if (account.getAccountNaam().equals(name)) {
                return account;
            }
        }
        return null;
    }

    public boolean isValidLogin(String name, String password) {
        /* EXECUTE QUERY */
        for (Account account : this.accounts) {
            if (account.getAccountNaam().equals(name) && account.getAccountWachtwoord().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public List<Account> getAll() {
        return this.accounts;
    }

    public Account find(int id) {
        /* EXECUTE QUERY */
        for (Account account : this.accounts) {
            if (account.getAccountId() == id) {
                return account;
            }
        }
        return null;
    }

    public void delete(int id) {
        /* EXECUTE QUERY */
        for (Account account : this.accounts) {
            if (account.getAccountId() == id) {
                accounts.remove(account);
                return;
            }
        }
    }

    public void add(Account newAccount) {
        /* EXECUTE QUERY */
        this.accounts.add(newAccount);
    }

    public void update(int id, Account updatedAccount) {
        /* EXECUTE QUERY */
        for (Account account : this.accounts) {
            if (account.getAccountId() == id) {
                accounts.set(accounts.indexOf(account), updatedAccount);
                return;
            }
        }
    }

}
