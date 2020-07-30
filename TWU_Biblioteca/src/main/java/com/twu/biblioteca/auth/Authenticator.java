package com.twu.biblioteca.auth;

public interface Authenticator {
    boolean authenticatorLogin(User user) throws ErrorValidationException;
}
