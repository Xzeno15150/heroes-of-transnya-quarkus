package fr.multiplatform.hot.services.connections;

import fr.multiplatform.hot.exceptions.UserNotFoundException;
import fr.multiplatform.hot.resources.dtos.auth.AuthRequest;

public abstract class UserJWTProvider {
    public abstract String getUserJWT(AuthRequest userDTO) throws UserNotFoundException;
}