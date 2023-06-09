package fr.multiplatform.hot.entities.user;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.character.Character;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String username;
    private List<Role> roles = new ArrayList<>();
    public User(String email, String username, String password, List<Role> roles) {
        this.email = email;
        this.username = username;
        this.roles = roles;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }
}
