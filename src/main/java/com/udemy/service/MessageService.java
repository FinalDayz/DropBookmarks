package com.udemy.service;

import com.udemy.model.Experiment;
import com.udemy.persistence.MessageDAO;
import org.skife.jdbi.v2.DBI;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

public class MessageService extends BaseService<Experiment> {

    private final MessageDAO dao;
    private final DBI database;

    @Inject
    public MessageService(DBI jdbi) {
        this.database = jdbi;
        dao = this.database.onDemand(MessageDAO.class);
    }

    //public void addMessage(String message){dao.addMessage();}

//    public void getmessage(){dao.getMessages()}

    public Collection<Experiment> getAll() {
        return dao.getAll();
    }


}
