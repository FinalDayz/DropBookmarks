package com.udemy.resources;

import com.fasterxml.jackson.annotation.JsonView;
import com.udemy.View;
import com.udemy.model.ExperimentDetails;
import com.udemy.service.ExperimentDetailsService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Singleton
@Path("/experimentDetails")
@Produces(MediaType.APPLICATION_JSON)
public class ExperimentDetailsResource {

    private final ExperimentDetailsService service;

    @Inject
    public ExperimentDetailsResource(ExperimentDetailsService service) {
        this.service = service;
    }

    @GET
    @JsonView(View.Public.class)
    public Collection<ExperimentDetails> retrieveAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public ExperimentDetails retrieve(@PathParam("id") int id)
    {
        return service.find(id);
    }
    
}
