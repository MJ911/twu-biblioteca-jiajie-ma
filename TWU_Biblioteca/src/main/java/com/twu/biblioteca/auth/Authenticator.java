package com.twu.biblioteca.auth;

public interface Authenticator {
    void authenticatorLogin(User user) throws ErrorValidationException;
}
