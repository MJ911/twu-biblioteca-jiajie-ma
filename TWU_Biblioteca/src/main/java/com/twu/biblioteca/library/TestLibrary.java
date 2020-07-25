package com.twu.biblioteca.library;


import java.util.List;
import java.util.Optional;

public final class TestLibrary implements Library {
    private final List<Book> books;

    public TestLibrary(List<Book> initBooks) {
        this.books = initBooks;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Optional<Book> getBookInfoByBookNo() {

        return Optional.empty();
    }
}
