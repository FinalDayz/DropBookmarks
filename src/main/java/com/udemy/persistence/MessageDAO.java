package com.udemy.persistence;

import com.udemy.model.Message;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface MessageDAO {

    @SqlUpdate()
    void addMessage(int experimentId, int accountId, Message message);

}
