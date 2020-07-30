package com.twu.biblioteca.auth;

public interface Authenticator {
    void authenticatorLogin(LoginInfo loginInfo) throws ErrorValidationException;
}
