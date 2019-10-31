package com.udemy.resources;

import com.fasterxml.jackson.annotation.JsonView;
import com.udemy.View;
import com.udemy.model.Experiment;
import com.udemy.model.ExperimentDetails;
import com.udemy.service.ExperimentService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Singleton
@Path("/experimenten")
@Produces(MediaType.APPLICATION_JSON)
public class ExperimentResource {

    private final ExperimentService service;

    @Inject
    public ExperimentResource(ExperimentService service) {
        this.service = service;
    }

    @GET
    @JsonView(View.Public.class)
    public Collection<Experiment> retrieveAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Experiment retrieve(@PathParam("id") int id)
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
    public void insert(Experiment experiment)
    {
        service.add(experiment);
    }

    @POST
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") int id, Experiment experiment)
    {
        service.update(id, experiment);
    }
}
