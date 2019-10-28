package com.udemy.service;

import com.udemy.model.VasteDienst;
import com.udemy.persistence.VasteDienstDAO;

import javax.inject.Inject;
import java.util.Collection;

public class VasteDienstService extends BaseService<VasteDienst> {
    private final VasteDienstDAO dao;

    @Inject
    public VasteDienstService(VasteDienstDAO vasteDienstDAO) {
        this.dao = vasteDienstDAO;
    }

    public Collection<VasteDienst> getAll() {
        return dao.getAll();
    }

    public VasteDienst find(int id) {
        return requireResult(dao.find(id));
    }

    public void add(VasteDienst vasteDienst) {
        dao.add(vasteDienst);
    }

    public void update(int id, VasteDienst vasteDienst) {
        dao.update(id, vasteDienst);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
