package com.udemy.persistence;

import com.udemy.model.ExperimentDetails;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExperimentDetailsMapper implements ResultSetMapper<ExperimentDetails> {

    @Override
    public ExperimentDetails map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        ExperimentDetails mappedExperimentDetails = new ExperimentDetails();
        mappedExperimentDetails.setStatus(resultSet.getString("status"));
        mappedExperimentDetails.setVoortgang(resultSet.getString("voortgang"));
        mappedExperimentDetails.setNetwerk(resultSet.getString("netwerk"));
        mappedExperimentDetails.setDoorlooptijd(resultSet.getString("doorlooptijd"));
        mappedExperimentDetails.setBeschrijving(resultSet.getString("beschrijving"));
        mappedExperimentDetails.setArchief(resultSet.getBoolean("archief"));
        mappedExperimentDetails.setExperimentId(resultSet.getInt("experiment_ID"));
        mappedExperimentDetails.setKostenAnders(resultSet.getString("kosten_anders"));
        mappedExperimentDetails.setKostenInovatie(resultSet.getString("kosten_inovatie"));
        mappedExperimentDetails.setStatusKleur(resultSet.getString("status_kleur"));
        mappedExperimentDetails.setArchiefType(resultSet.getString("archief_type"));

        return mappedExperimentDetails;
    }
}
