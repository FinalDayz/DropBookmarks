package com.udemy.service;

import com.udemy.model.Experiment;
import com.udemy.persistence.ExperimentDAO;
import org.skife.jdbi.v2.DBI;

import javax.inject.Inject;
import java.util.Collection;

public class ExperimentService extends BaseService<Experiment> {

    private final ExperimentDAO dao;
    private final DBI database;

    @Inject
    public ExperimentService(DBI jdbi) {
        this.database = jdbi;
        dao = this.database.onDemand(ExperimentDAO.class);

    }

    public Collection<Experiment> getAll() {
        return dao.getAll();
    }

    public Experiment find(int id) {
        return requireResult(dao.find(id));
    }

    public void add(Experiment experiment) {
        dao.add(experiment);
    }

    public void update(int id, Experiment experiment) {
        dao.update(id, experiment);
    }

    public void delete(int id) {
        dao.delete(id);
    }

}
