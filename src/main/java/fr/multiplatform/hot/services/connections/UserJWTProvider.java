package fr.multiplatform.hot.services.connections;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.exceptions.UserNotFoundException;
import fr.multiplatform.hot.resources.dtos.ConnectionUserDTO;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public abstract class UserJWTProvider {

    @ConfigProperty(name="jwt.issuer")
    private String issuer;

    @ConfigProperty(name = "jwt.secret")
    private String jwtSecret;

    @ConfigProperty(name = "jwt.ttl")
    private int jwtTTL;


    public String getUserJWT(ConnectionUserDTO userDTO) {
        User user = getUser(userDTO);
        if (user == null) {
            throw new UserNotFoundException("Mot de passe ou login invalid");
        }

        List<String> roles = user.getRoles().stream()
                .map(Role::toString)
                .collect(Collectors.toList());

        return this.createToken(user.getEmail(), user.getUsername(), roles);
    }


    public String createToken(String email, String username, List<String> roles) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        Instant now = Instant.now();
        return JWT.create()
                .withClaim("email", email)
                .withClaim("username", username)
                .withClaim("groups", roles)
                .withIssuer(issuer)
                .withIssuedAt(now)
                .withExpiresAt(now.plus(jwtTTL, ChronoUnit.SECONDS))
                .sign(algorithm);
    }
    protected abstract User getUser(ConnectionUserDTO userDTO);
}