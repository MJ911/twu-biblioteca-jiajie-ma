package com.twu.biblioteca;

import com.twu.biblioteca.auth.LoginInfo;
import com.twu.biblioteca.auth.User;
import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Movie;
import com.twu.biblioteca.library.TestLibraryBooks;
import com.twu.biblioteca.library.TestLibraryMovies;

import java.util.Arrays;
import java.util.List;

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
                new Movie("1","X MAN", 2001, "Eric", "7", true),
                new Movie("2","X MAN 2", 2004, "Eric & Nick", "9", true),
                new Movie("3","X MAN 3", 2010, "Nick", "10", true)
        ));
    }

    public static List<User> provideUsers() {
        return Arrays.asList(
                new User("123456", "123456", "UserA", "123456@thoughtworks.com", "12345677714"),
                new User("123456789", "123456789", "UserB", "456789@thoughtworks.com", "12345689714"),
                new User("admin", "123456", "UserC", "321789@thoughtworks.com", "11255677714"));
    }
}
