package com.udemy.persistence;

import com.udemy.model.Experiment;
import com.udemy.model.Message;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements ResultSetMapper<Message> {
    @Override
    public Message map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Message mappedExperiment = new Message();
        mappedExperiment.setAccountId(resultSet.getInt("account_ID"));
        mappedExperiment.setBericht(resultSet.getString("Bericht"));
        mappedExperiment.setMessageId(resultSet.getInt("message_ID"));
        mappedExperiment.setExperimentId(resultSet.getInt("experiment_ID"));
        mappedExperiment.setDateTime(resultSet.getString("date"));
        mappedExperiment.setEditorName(resultSet.getString("account_naam"));
        return mappedExperiment;
    }
}