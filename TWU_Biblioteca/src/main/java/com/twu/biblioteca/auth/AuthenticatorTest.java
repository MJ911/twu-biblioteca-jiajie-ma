package com.twu.biblioteca.auth;

public class AuthenticatorTest implements Authenticator {
    @Override
    public boolean authenticatorLogin(User user) throws ErrorValidationException {
        return true;
    }
}
