package fr.multiplatform.hot.services.connections.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.exceptions.UserNotFoundException;
import fr.multiplatform.hot.resources.dtos.ConnectionUserDTO;
import fr.multiplatform.hot.services.connections.UserJWTProvider;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StubProvider extends UserJWTProvider {

    @ConfigProperty(name="users.admin.email")
    String adminEmail;
    @ConfigProperty(name="users.admin.password")
    String adminPassword;

    @ConfigProperty(name="users.user1.email")
    private String user1Email;
    @ConfigProperty(name="users.user1.password")
    private String user1Password;

    @ConfigProperty(name="users.user2.email")
    private String user2Email;
    @ConfigProperty(name="users.user2.password")
    private String user2Password;

    @ConfigProperty(name="jwt.issuer")
    private String issuer;

    @ConfigProperty(name = "jwt.secret")
    private String jwtSecret;

    @ConfigProperty(name = "jwt.ttl")
    private int jwtTTL;

    @Override
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

    private User getUser(ConnectionUserDTO userDTO) {
        if (adminEmail.equals(userDTO.getEmail()) &&
            adminPassword.equals(userDTO.getPassword())){
            return getAdminUser();
        } else if (user1Email.equals(userDTO.getEmail()) &&
                   user1Password.equals(userDTO.getPassword())) {
            return getUser1();
        } else if (user2Email.equals(userDTO.getEmail()) &&
                    user2Password.equals(userDTO.getPassword())) {
            return getUser2();
        }
        return null;
    }

    private User getAdminUser() {
        return new User()
                .setEmail(adminEmail)
                .setPassword(adminPassword)
                .setRoles(new ArrayList<>(List.of(Role.ROLE_ADMIN, Role.ROLE_USER)))
                .setUsername("Admin");
    }

    private User getUser1() {
        return new User()
                .setEmail(user1Email)
                .setPassword(user1Password)
                .setRoles(new ArrayList<>(List.of(Role.ROLE_USER)))
                .setUsername("Érina");
    }

    private User getUser2(){
        return new User()
                .setEmail(user2Email)
                .setPassword(user2Password)
                .setRoles(new ArrayList<>(List.of(Role.ROLE_USER)))
                .setUsername("Neitah");
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
}
