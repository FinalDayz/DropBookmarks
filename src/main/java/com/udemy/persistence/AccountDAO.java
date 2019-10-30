package com.udemy.persistence;

import com.udemy.model.Account;
import com.udemy.model.Experiment;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public interface AccountDAO {

    @SqlQuery("SELECT * FROM account WHERE account_naam = :name")
    @Mapper(AccountMapper.class)
    public Account findName(@Bind("name") String name);

    @SqlQuery("SELECT count(*) FROM account WHERE account_naam = :name AND account_wachtwoord = :password")
    public int isValidLogin(@Bind("name")String name, @Bind("password") String password);

    @SqlQuery("SELECT * FROM account")
    @Mapper(AccountMapper.class)
    public List<Account> getAll();

    @SqlUpdate("DELETE FROM account WHERE account_id = :accountId")
    public void delete(@Bind("accountId") int id);

    @SqlUpdate("DELETE FROM account WHERE account_naam = :accountName")
    public void delete(@Bind("accountName") String accountName);

    @SqlUpdate("INSERT INTO account (account_naam, account_wachtwoord, account_rol) " +
            "VALUES (:accountNaam, :accountWachtwoord, :accountRol)")
    public void add(@BindBean Account newAccount);

    @SqlUpdate("UPDATE account (" +
            "account_naam = :accountNaam," +
            "account_wachtwoord = :accountWachtwoord," +
            "account_rol = :account_rol" +
            ")")
    public void update(int id, Account updatedAccount);

}
