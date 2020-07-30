package com.twu.biblioteca.auth;

import com.twu.biblioteca.library.Item;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {
    private Map<LoginInfo, Item> userItemInfoMap;

    public UserInfo() {
        this.userItemInfoMap = new HashMap<>();
    }

    public Map<LoginInfo, Item> getUserItemInfoMap() {
        return userItemInfoMap;
    }

    public void setUserItemInfoMap(Map<LoginInfo, Item> userItemInfoMap) {
        this.userItemInfoMap = userItemInfoMap;
    }
}
