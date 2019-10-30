package com.udemy.persistence;

import com.udemy.model.Message;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface MessageDAO {

    @SqlUpdate("INSERT INTO message (account_ID, experiment_ID, Bericht, date) " +
            "VALUES (:experiment_naam, :wijziging_datum, :fase, :experiment_leider)")
    void addMessage(int experimentId, int accountId, Message message);

}
