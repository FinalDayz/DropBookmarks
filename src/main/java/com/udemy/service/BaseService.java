package com.udemy.service;

import javax.ws.rs.NotFoundException;
/**
 * @author Stefan
 */
public class BaseService<T> {
    public T requireResult(T model)
    {
        if (model == null)
        {
            throw new NotFoundException();
        }

        return model;
    }
}
