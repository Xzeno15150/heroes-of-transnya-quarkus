package fr.multiplatform.hot.exceptions.dal;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class CannotInsertException extends WebApplicationException {
    public CannotInsertException(Class<?> clazz) {
        super(Response.status(400).entity("Cannot create a document for "+clazz.getName()+" entity.").build());
    }
}
