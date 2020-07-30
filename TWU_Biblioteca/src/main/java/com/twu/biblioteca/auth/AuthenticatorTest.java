package com.twu.biblioteca.auth;

import java.util.List;
import java.util.Optional;

public class AuthenticatorTest implements Authenticator {
    private List<User> users;

    public AuthenticatorTest(List<User> users) {
        this.users = users;
    }

    @Override
    public void authenticatorLogin(LoginInfo loginUser) throws ErrorValidationException {
        Optional<User> checkUser = users.stream().filter(user -> user.isSameUser(loginUser)).findFirst();
        if(!checkUser.isPresent()) {
            throw new ErrorValidationException();
        }
    }
}
