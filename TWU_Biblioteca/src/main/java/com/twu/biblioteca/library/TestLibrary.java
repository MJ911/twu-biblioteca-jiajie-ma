package com.twu.biblioteca.library;

import java.util.List;

public final class TestLibrary implements Library {
    private final List<Book> books;

    public TestLibrary(List<Book> initBooks) {
        this.books = initBooks;
    }

    public List<Book> getAllBooks() {
        return books;
    }
}