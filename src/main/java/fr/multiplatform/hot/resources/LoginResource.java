package fr.multiplatform.hot.resources;

import fr.multiplatform.hot.resources.dtos.auth.AuthRequest;
import fr.multiplatform.hot.resources.dtos.auth.AuthResponse;
import fr.multiplatform.hot.services.connections.UserJWTProvider;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
public class LoginResource {

    @Inject
    UserJWTProvider userJWTProvider;

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuthResponse getJwt(AuthRequest user) {
        return new AuthResponse().setToken(userJWTProvider.getUserJWT(user));
    }
}
