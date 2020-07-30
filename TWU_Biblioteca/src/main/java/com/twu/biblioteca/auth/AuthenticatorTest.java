package com.twu.biblioteca.auth;

import java.util.List;
import java.util.Optional;

public class AuthenticatorTest implements Authenticator {
    private List<LoginInfo> loginInfo;

    public AuthenticatorTest(List<LoginInfo> loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Override
    public void authenticatorLogin(LoginInfo loginUser) throws ErrorValidationException {
        Optional<LoginInfo> checkUser = loginInfo.stream().filter(user -> user.equals(loginUser)).findFirst();
        if(!checkUser.isPresent()) {
            throw new ErrorValidationException();
        }
    }
}
