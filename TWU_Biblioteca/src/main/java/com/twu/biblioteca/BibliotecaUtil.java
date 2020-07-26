package com.twu.biblioteca;


import com.twu.biblioteca.console.Option;

import java.util.Arrays;
import java.util.List;

public final class BibliotecaUtil {

    public static List<Option> getAllOptions() {
        return Arrays.asList(
                new Option("1", "List of Books"),
                new Option("2", "Return Book"),
                new Option("Q", "exit the Application"));
    }
}
