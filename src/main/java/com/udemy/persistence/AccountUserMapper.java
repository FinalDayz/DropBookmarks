package com.udemy.persistence;

import com.udemy.model.Account;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Stefan
 */
public class AccountUserMapper  implements ResultSetMapper<Account> {

    @Override
    public Account map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Account mappedAccount = new Account ();
        mappedAccount.setAccountId (resultSet.getInt ("account_ID"));
        mappedAccount.setAccountNaam (resultSet.getString ("account_naam"));
        mappedAccount.setAccountRol (resultSet.getString ("account_rol"));
        return mappedAccount;
    }
}