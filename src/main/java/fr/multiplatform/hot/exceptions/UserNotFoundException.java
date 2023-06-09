package fr.multiplatform.hot.exceptions;


import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class UserNotFoundException extends WebApplicationException {
    public UserNotFoundException() {
        super(Response.status(401).entity("User not found. \nInvalid password or login.").build());
    }
}
