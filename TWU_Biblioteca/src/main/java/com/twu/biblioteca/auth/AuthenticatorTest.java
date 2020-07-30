package com.twu.biblioteca.auth;

import java.util.List;

public class AuthenticatorTest implements Authenticator {
    private List<User> users;

    public AuthenticatorTest(List<User> users) {
        this.users = users;
    }

    @Override
    public void authenticatorLogin(User loginUser) throws ErrorValidationException {

    }
}
