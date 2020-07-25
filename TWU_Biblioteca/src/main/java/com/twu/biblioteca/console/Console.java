package com.twu.biblioteca.console;

import java.io.PrintStream;

public class Console {
    private final PrintStream printer = System.out;

    public void start() {
        this.welcome();
    }
    public void welcome() {
        printer.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
