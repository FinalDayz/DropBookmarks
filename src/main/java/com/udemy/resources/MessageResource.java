package com.udemy.resources;



import com.udemy.service.MessageService;

import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class MessageResource {


    @Singleton
    @Path("/experimenten")
    @Produces(MediaType.APPLICATION_JSON)
    public class MeassageResource {

//        private final MessageService service;
    }
}
