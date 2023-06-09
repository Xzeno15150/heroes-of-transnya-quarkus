package fr.multiplatform.hot.resources.dtos.common;

import fr.multiplatform.hot.entities.user.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

@RequestScoped
public class UserJWTResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    @Claim(standard = Claims.preferred_username)
    String $username;

    protected User user() {
        return new User()
                .setEmail(jwt.getName())
                .setUsername($username);
    }
}
