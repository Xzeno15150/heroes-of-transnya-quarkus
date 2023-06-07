package fr.multiplatform.hot.exceptions;


import io.quarkus.security.UnauthorizedException;

public class UserNotFoundException extends UnauthorizedException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
