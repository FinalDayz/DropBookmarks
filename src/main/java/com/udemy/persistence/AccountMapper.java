package com.udemy.persistence;

import com.udemy.model.Account;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Assigns values from database to an object
 * @author Stefan
 */
public class AccountMapper implements ResultSetMapper<Account> {

    @Override
    public Account map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Account mappedAccount = new Account();
        mappedAccount.setAccountId(resultSet.getInt("account_ID"));
        mappedAccount.setAccountNaam(resultSet.getString("account_naam"));
        mappedAccount.setAccountWachtwoord(resultSet.getString("account_wachtwoord"));
        mappedAccount.setAccountRol(resultSet.getString("account_rol"));
        return mappedAccount;
    }
}
