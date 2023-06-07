package fr.multiplatform.hot.services.connections.providers;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.user.User;
import fr.multiplatform.hot.resources.dtos.ConnectionUserDTO;
import fr.multiplatform.hot.services.connections.UserJWTProvider;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    protected User getUser(ConnectionUserDTO userDTO) {
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
}
