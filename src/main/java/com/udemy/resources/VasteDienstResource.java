package com.udemy.resources;

import com.fasterxml.jackson.annotation.JsonView;
import com.udemy.View;
import com.udemy.model.VasteDienst;
import com.udemy.service.VasteDienstService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Singleton
@Path("/vasteDiensten")
@Produces(MediaType.APPLICATION_JSON)
public class VasteDienstResource {

    private final VasteDienstService service;

    @Inject
    public VasteDienstResource(VasteDienstService service) {
        this.service = service;
    }

    @GET
    @JsonView(View.Public.class)
    public Collection<VasteDienst> retrieveAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public VasteDienst retrieve(@PathParam("id") int id)
    {
        return service.find(id);
    }
}
