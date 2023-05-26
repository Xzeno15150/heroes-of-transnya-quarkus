package fr.multiplatform.hot.entities.user;

import fr.multiplatform.hot.entities.Role;
import fr.multiplatform.hot.entities.character.Character;

import java.util.List;

public class User {
    private String id;
    private String username;
    private String password;
    private List<Role> roles;
    private List<Character> characters;

    public User(String id, String username, String password, List<Role> roles, List<Character> characters) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.characters = characters;
    }

    public User(String username, String password, List<Role> roles, List<Character> characters) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.characters = characters;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
