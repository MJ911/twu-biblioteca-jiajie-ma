package com.twu.biblioteca.auth;

import com.twu.biblioteca.library.Item;

public class UserInfo {
    private User user;
    private Item item;

    public UserInfo(User user, Item item) {
        this.user = user;
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
