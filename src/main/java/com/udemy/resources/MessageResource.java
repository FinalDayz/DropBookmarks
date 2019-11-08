package com.udemy.resources;



import com.udemy.model.Experiment;
import com.udemy.model.Message;
import com.udemy.service.AccountService;
import com.udemy.service.MessageService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Stefan, Bart
 */
@Singleton
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private final MessageService service;

    @Inject
    public MessageResource(MessageService service) {
        this.service = service;
    }

    @GET
    @Path("/{experimentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Experiment> retrieve(@PathParam("experimentId") int experimentId)
    {
        return service.fromExperimenten(experimentId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addMessage/")
    public void insert(Message message) {
        service.addMessage(message);
    }
}
