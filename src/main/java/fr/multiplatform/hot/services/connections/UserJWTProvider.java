package fr.multiplatform.hot.services.connections;

import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.resources.dtos.ConnectionUserDTO;

public abstract class UserJWTProvider {
    public abstract String getUserJWT(ConnectionUserDTO userDTO);
}