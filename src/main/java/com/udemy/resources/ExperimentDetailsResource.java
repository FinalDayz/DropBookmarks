package com.udemy.resources;

import com.fasterxml.jackson.annotation.JsonView;
import com.udemy.View;
import com.udemy.model.ExperimentDetails;
import com.udemy.service.ExperimentDetailsService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
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
    @Path("/{id}")
    @JsonView(View.Public.class)
    public ExperimentDetails retrieve(@PathParam("id") int id)
    {
        return service.find(id);
    }

    @POST
    @Path("/delete/{id}")
    @JsonView(View.Public.class)
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(ExperimentDetails experimentDetails)
    {
        service.add(experimentDetails);
    }

    @POST
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") int id, ExperimentDetails experimentDetails)
    {
        service.update(id, experimentDetails);
    }
}
