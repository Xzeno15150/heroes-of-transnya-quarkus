package fr.multiplatform.hot.services.connections;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.exceptions.UserNotFoundException;
import fr.multiplatform.hot.resources.dtos.ConnectionUserDTO;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Set;
import java.util.stream.Collectors;


public abstract class UserJWTProvider {

    @ConfigProperty(name="jwt.issuer")
    private String issuer;

    public String getUserJWT(ConnectionUserDTO userDTO) {
        User user = getUser(userDTO);
        if (user == null) {
            throw new UserNotFoundException("Mot de passe ou login invalid");
        }

        Set<String> roles = user.getRoles().stream()
                .map(Role::toString)
                .collect(Collectors.toSet());

        return Jwt.issuer(issuer)
                .groups(roles)
                .claim("email", user.getEmail())
                .claim("username", user.getUsername())
                .sign();
    }

    protected abstract User getUser(ConnectionUserDTO userDTO);
}
