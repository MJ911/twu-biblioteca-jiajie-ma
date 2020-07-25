package com.twu.biblioteca.console;

import java.util.List;

public class Menu {
    private List<Option> menuItem;

    public Menu(List<Option> menuItem) {
        this.menuItem = menuItem;
    }

    public List<Option> getMenuItem() {
        return menuItem;
    }
}
