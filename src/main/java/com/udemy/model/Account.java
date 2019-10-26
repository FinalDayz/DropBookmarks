package com.udemy.model;

import io.dropwizard.validation.OneOf;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Account {

    @NotNull
    private int accountId;

    @NotNull
    @Length(max=50)
    private String accountNaam;

    @NotNull
    @Length(max=50)
    private String accountWachtwoord;

    @NotNull
    @OneOf(value = {"'Admin', 'Medewerker', 'Gebruiker"})
    private String accountRol;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNaam() {
        return accountNaam;
    }

    public void setAccountNaam(String accountNaam) {
        this.accountNaam = accountNaam;
    }

    public String getAccountWachtwoord() {
        return accountWachtwoord;
    }

    public void setAccountWachtwoord(String accountWachtwoord) {
        this.accountWachtwoord = accountWachtwoord;
    }

    public String getAccountRol() {
        return accountRol;
    }

    public void setAccountRol(String accountRol) {
        this.accountRol = accountRol;
    }
}
