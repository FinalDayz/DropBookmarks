package com.udemy.resources;

import com.fasterxml.jackson.annotation.JsonView;
import com.udemy.View;
import com.udemy.model.Account;
import com.udemy.model.Experiment;
import com.udemy.service.AccountService;
import com.udemy.service.ExperimentService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Singleton
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    private final AccountService service;

    @Inject
    public AccountResource(AccountService service) {
        this.service = service;
    }

    @GET
    @JsonView(View.Public.class)
    public Collection<Account> retrieveAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Account retrieve(@PathParam("id") int id)
    {
        return service.find(id);
    }

    @GET
    @Path("/{name}")
    @JsonView(View.Public.class)
    public Account retrieve(@PathParam("name") String name)
    {
        return service.findName(name);
    }
}
