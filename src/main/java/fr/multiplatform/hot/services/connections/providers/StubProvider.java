package fr.multiplatform.hot.services.connections.providers;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.exceptions.UserNotFoundException;
import fr.multiplatform.hot.resources.dtos.auth.AuthRequest;
import fr.multiplatform.hot.services.connections.UserJWTProvider;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.RequestScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
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

    @ConfigProperty(name="mp.jwt.verify.issuer")
    private String issuer;

    @ConfigProperty(name = "jwt.secret")
    private String jwtSecret;

    @ConfigProperty(name = "jwt.ttl")
    private int jwtTTL;

    @Override
    public String getUserJWT(AuthRequest userDTO) {
            User user = getUser(userDTO);
            if (user == null) {
                throw new UserNotFoundException("Mot de passe ou login invalid");
            }

            List<String> roles = user.getRoles().stream()
                    .map(Role::toString)
                    .collect(Collectors.toList());

            return this.createToken(user.getEmail(), user.getUsername(), roles);
    }

    private User getUser(AuthRequest userDTO) {
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
                .setRoles(new ArrayList<>(List.of(Role.ROLE_ADMIN, Role.ROLE_USER)))
                .setUsername("Admin");
    }

    private User getUser1() {
        return new User()
                .setEmail(user1Email)
                .setRoles(new ArrayList<>(List.of(Role.ROLE_USER)))
                .setUsername("Érina");
    }

    private User getUser2(){
        return new User()
                .setEmail(user2Email)
                .setRoles(new ArrayList<>(List.of(Role.ROLE_USER)))
                .setUsername("Neitah");
    }
    public String createToken(String email, String username, List<String> roles) {
        Instant now = Instant.now();
        return Jwt.issuer(issuer)
                .upn(email)
                .claim(Claims.preferred_username, username)
                .groups(new HashSet<>(roles))
                .issuedAt(now)
                .expiresAt(now.plus(jwtTTL, ChronoUnit.SECONDS))
                .sign();
    }
}
