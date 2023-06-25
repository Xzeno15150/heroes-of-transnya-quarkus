package fr.multiplatform.hot.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class CharacterNotFoundException extends WebApplicationException {
    public CharacterNotFoundException(String id) {
        super(Response.status(404).entity("Cannot find character "+id).build());
    }

}
