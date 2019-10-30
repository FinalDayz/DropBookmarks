package com.udemy.resources;

import com.fasterxml.jackson.annotation.JsonView;
import com.udemy.View;
import com.udemy.model.Account;
import com.udemy.model.Experiment;
import com.udemy.service.AccountService;
import com.udemy.service.ExperimentService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
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
    @Path("/{name}/{password}")
    @JsonView(View.Public.class)
    public boolean retrieve(@PathParam("name") String name, @PathParam("password") String password)
    {
        return service.isValidLogin(name, password);
    }

    @POST
    @Path("/delete/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public void delete(@PathParam("id") int accountId) {
        service.delete(accountId);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Account person) {
        service.add(person);
    }

}
