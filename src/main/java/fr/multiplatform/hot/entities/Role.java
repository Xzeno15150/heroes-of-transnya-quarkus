package fr.multiplatform.hot.entities;

public enum Role {
    ROLE_USER,
    ROLE_ADMIN;

    public static class Names {
        public static final String ROLE_USER = "ROLE_USER";
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
    }

    @Override
    public String toString() {
        return name();
    }
}
