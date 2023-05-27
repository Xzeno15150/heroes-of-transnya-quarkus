package fr.multiplatform.hot.entities.user;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.character.Character;

import java.util.List;

public class User {
    private String email;
    private String username;
    private String password;
    private List<Role> roles;
    private List<Character> characters;

    public User(String email, String username, String password, List<Role> roles, List<Character> characters) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.characters = characters;
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

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public User setCharacters(List<Character> characters) {
        this.characters = characters;
        return this;
    }
}
