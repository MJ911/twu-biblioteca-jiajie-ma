package com.twu.biblioteca.auth;

import java.util.Objects;

public class LoginInfo {
    private String userId;
    private String userPassword;

    public LoginInfo(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginInfo)) return false;
        LoginInfo loginInfo = (LoginInfo) o;
        return Objects.equals(getUserId(), loginInfo.getUserId()) &&
                Objects.equals(getUserPassword(), loginInfo.getUserPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserPassword());
    }

    @Override
    public String toString() {
        final String ENTRY_FORMAT = "%-20s | %-20s\n";
        return String.format(ENTRY_FORMAT, getUserId(), getUserPassword());

    }
}
