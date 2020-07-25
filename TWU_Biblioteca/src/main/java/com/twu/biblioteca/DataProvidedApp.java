package com.twu.biblioteca;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.TestLibrary;

import java.util.Arrays;

public final class DataProvidedApp {
    private DataProvidedApp() {
    }

    public static TestLibrary provideBookLibrary() {
        return new TestLibrary(Arrays.asList(
                new Book("1","Dimtree", 1992),
                new Book("2","Nick M", 2003),
                new Book("3","Mint", 2005)));
    }
}
