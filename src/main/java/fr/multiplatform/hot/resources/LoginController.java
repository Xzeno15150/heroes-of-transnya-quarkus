package fr.multiplatform.hot.resources;

import fr.multiplatform.hot.resources.dtos.ConnectionUserDTO;
import fr.multiplatform.hot.services.connections.UserJWTProvider;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
public class LoginController {

    @Inject
    UserJWTProvider userJWTProvider;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getJwt(ConnectionUserDTO user){
        return userJWTProvider.getUserJWT(user);
    }
}
