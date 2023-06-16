package fr.multiplatform.hot.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class PartyNotFoundException extends WebApplicationException {

    public PartyNotFoundException(String id) {
        super(Response.status(404).entity("Cannot find party "+id).build());
    }
}
