package com.udemy.service;

import com.udemy.model.Experiment;
import com.udemy.model.ExperimentDetails;
import com.udemy.persistence.ExperimentDAO;
import com.udemy.persistence.ExperimentDetailsDAO;

import javax.inject.Inject;
import java.util.Collection;

public class ExperimentDetailsService extends BaseService<ExperimentDetails> {
    private final ExperimentDetailsDAO dao;

    @Inject
    public ExperimentDetailsService(ExperimentDetailsDAO experimentDetailsDAO) {
        this.dao = experimentDetailsDAO;
    }

    public Collection<ExperimentDetails> getAll() {
        return dao.getAll();
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
