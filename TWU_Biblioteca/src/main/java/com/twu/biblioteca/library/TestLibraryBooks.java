package com.twu.biblioteca.library;


import java.util.List;
import java.util.Optional;

public final class TestLibraryBooks implements Library<Book> {
    private final List<Book> books;

    public TestLibraryBooks(List<Book> initBooks) {
        this.books = initBooks;
    }

    @Override
    public List<Book> getAllItems() {
        return books;
    }

    @Override
    public Optional<Book> getItemInfoByItemNo(String bookNo) {
        Optional<Book> checkBook = books.stream().filter(Book::isIn).filter(book -> bookNo.equals(book.getItemNo())).findFirst();
        checkBook.ifPresent(book -> book.setIn(false));

        return checkBook;
    }

    @Override
    public boolean returnItemByItemNo(String bookNo) {
        Optional<Book> checkBook = books.stream().filter(book -> bookNo.equals(book.getItemNo())).findFirst();
        if(!checkBook.isPresent() || checkBook.get().isIn()) {
            return false;
        }
        checkBook.ifPresent(book -> book.setIn(true));
        return true;
    }
}
