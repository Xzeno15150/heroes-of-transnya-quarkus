package fr.multiplatform.hot.resources.dtos.auth;

public class AuthResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public AuthResponse setToken(String token) {
        this.token = token;
        return this;
    }
}
