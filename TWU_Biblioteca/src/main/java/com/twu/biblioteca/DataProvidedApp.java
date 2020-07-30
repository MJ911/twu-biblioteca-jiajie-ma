package com.twu.biblioteca;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Movie;
import com.twu.biblioteca.library.TestLibraryBooks;
import com.twu.biblioteca.library.TestLibraryMovies;

import java.util.Arrays;

public final class DataProvidedApp {
    private DataProvidedApp() {
    }

    public static TestLibraryBooks provideBookLibrary() {
        return new TestLibraryBooks(Arrays.asList(
                new Book("1","Dimtree", 1992, true),
                new Book("2","Nick M", 2003,true),
                new Book("3","Mint", 2005,true)));
    }

    public static TestLibraryMovies provideMovieLibrary() {
        return new TestLibraryMovies(Arrays.asList(
                new Movie("1","X MAN", "2001", "Eric", "7", true),
                new Movie("2","X MAN 2", "2004", "Eric & Nick", "9", true),
                new Movie("3","X MAN 3", "2010", "Nick", "10", true)
        ));
    }
}
