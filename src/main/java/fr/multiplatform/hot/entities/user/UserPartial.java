package fr.multiplatform.hot.entities.user;

public class UserPartial {
    private String username;
    private String email;

    public UserPartial(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserPartial() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
