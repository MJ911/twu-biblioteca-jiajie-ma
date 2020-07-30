package com.twu.biblioteca;


import com.twu.biblioteca.console.Option;

import java.util.Arrays;
import java.util.List;

public final class BibliotecaUtil {

    public static List<Option> getAllOptions() {
        return Arrays.asList(
                new Option("1", "List of Books"),
                new Option("2", "Return Book"),
                new Option("3", "List of Movies"),
                new Option("4", "Choose a Movie"),
                new Option("5", "List of UserInfo"),
                new Option("6", "View my information"),
                new Option("Q", "exit the Application"));
    }
}
