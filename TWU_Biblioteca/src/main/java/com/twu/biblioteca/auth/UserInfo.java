package com.twu.biblioteca.auth;

import com.twu.biblioteca.library.Item;

import java.util.Map;

public class UserInfo {
    private Map<User, Item> userItemInfoMap;

    public UserInfo(Map<User, Item> userItemInfoMap) {
        this.userItemInfoMap = userItemInfoMap;
    }

    public Map<User, Item> getUserItemInfoMap() {
        return userItemInfoMap;
    }

    public void setUserItemInfoMap(Map<User, Item> userItemInfoMap) {
        this.userItemInfoMap = userItemInfoMap;
    }
}
