package com.twu.biblioteca.authTest;

import com.twu.biblioteca.auth.ErrorValidationException;
import com.twu.biblioteca.auth.LoginInfo;
import com.twu.biblioteca.auth.TestAuthenticator;
import com.twu.biblioteca.auth.User;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;


public class TestAuthenticatorTest {
    List<User> users = Arrays.asList(
            new User("123456", "123456", "UserA", "123456@thoughtworks.com", "12345677714"),
            new User("123456789", "123456789", "UserB", "456789@thoughtworks.com", "12345689714"),
            new User("admin", "123456", "UserC", "321789@thoughtworks.com", "11255677714"));
    TestAuthenticator testAuthenticator;

    @Test(expected=ErrorValidationException.class)
    public void should_throw_the_ErrorValidationException_when_not_check_the_LoginInfo() throws ErrorValidationException {
        testAuthenticator = new TestAuthenticator(users);
        LoginInfo loginInfoWrongTest = new LoginInfo("111", "222");
        testAuthenticator.authenticatorLogin(loginInfoWrongTest);
    }

    @Test
    public void should_get_the_user_info_from_the_loginInfo() {
        testAuthenticator = new TestAuthenticator(users);
        LoginInfo loginInfoTest = new LoginInfo("123456", "123456");
        User exceptedUser = new User("123456", "123456", "UserA", "123456@thoughtworks.com", "12345677714");
        User actualUser = testAuthenticator.getUserInfoByLoginInfo(loginInfoTest);

        assertEquals(exceptedUser.getUserId(), actualUser.getUserId());
        assertEquals(exceptedUser.getUserPassword(), actualUser.getUserPassword());
        assertEquals(exceptedUser.getUserName(), actualUser.getUserName());
        assertEquals(exceptedUser.getUserEmail(), actualUser.getUserEmail());
        assertEquals(exceptedUser.getUserPhone(), actualUser.getUserPhone());
    }
}
