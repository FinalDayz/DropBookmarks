package com.udemy.service;

import com.udemy.model.Experiment;
import com.udemy.model.ExperimentDetails;
import com.udemy.persistence.AccountDAO;
import com.udemy.persistence.ExperimentDAO;
import com.udemy.persistence.ExperimentDetailsDAO;
import org.skife.jdbi.v2.DBI;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;

@Singleton
public class ExperimentDetailsService extends BaseService<ExperimentDetails> {
    private final ExperimentDetailsDAO dao;
    private final DBI database;

    @Inject
    public ExperimentDetailsService(DBI jdbi) {
        this.database = jdbi;
        this.dao = database.onDemand(ExperimentDetailsDAO.class);
    }

    public ExperimentDetails find(int id) {
        return requireResult(dao.find(id));
    }

    public void add(ExperimentDetails experimentDetails) {
        dao.add(experimentDetails);
    }

    public void update(int id, ExperimentDetails experimentDetails) {
        dao.update(id, experimentDetails);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
