package fr.multiplatform.hot.resources.dtos;

public class ConnectionUserDTO {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public ConnectionUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ConnectionUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
