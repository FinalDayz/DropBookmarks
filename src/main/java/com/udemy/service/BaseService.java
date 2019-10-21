package com.udemy.service;

import com.udemy.model.Experiment;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

public class BaseService<T> {
    public T requireResult(T model)
    {
        if (model == null)
        {
            throw new NotFoundException();
        }

        return model;
    }

    public void assertSelf(Experiment experiment1, Experiment experiment2)
    {
        if (!experiment1.equals(experiment2))
        {
            throw new ForbiddenException();
        }
    }
}
