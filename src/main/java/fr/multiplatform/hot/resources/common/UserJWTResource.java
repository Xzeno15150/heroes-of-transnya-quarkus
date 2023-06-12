package fr.multiplatform.hot.resources.common;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.user.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;
import java.util.stream.Collectors;

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
                .setUsername($username)
                .setRoles(jwt.getGroups().stream()
                        .map(Role::valueOf)
                        .collect(Collectors.toList()));
    }
}
