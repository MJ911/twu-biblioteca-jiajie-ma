package com.twu.biblioteca.auth;

import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
    private String userPhone;

    public User(String userId, String userPassword, String userName, String userEmail, String userPhone) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s |  %-20s | %-20s\n";
        return String.format(ENTRY_FORMAT, getUserId(), getUserPassword(), getUserName(), getUserEmail(), getUserPhone());
    }

    public boolean isSameUser(LoginInfo checkUser) {
        return checkUser.getUserId().equals(this.getUserId()) && checkUser.getUserPassword().equals(this.getUserPassword());
    }
}
