package com.udemy.resources;



import com.fasterxml.jackson.annotation.JsonView;
import com.udemy.View;
import com.udemy.model.Experiment;
import com.udemy.model.Message;
import com.udemy.service.MessageService;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private final MessageService service;

    public MessageResource(MessageService service) {
        this.service = service;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMessage/")
    public void insert(Message message) {
        service.addMessage(message);
    }
    @JsonView(View.Public.class)

    @Singleton
    @Path("/experimenten")
    @Produces(MediaType.APPLICATION_JSON)
    public class MeassageResource {

//        private final MessageService service;
    }

}
