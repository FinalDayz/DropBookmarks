package com.udemy.service;

import com.udemy.model.Experiment;
import com.udemy.persistence.ExperimentDAO;

import javax.inject.Inject;
import java.util.Collection;

public class ExperimentService extends BaseService<Experiment> {
    private final ExperimentDAO dao;

    @Inject
    public ExperimentService(ExperimentDAO experimentDAO) {
        this.dao = experimentDAO;
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
