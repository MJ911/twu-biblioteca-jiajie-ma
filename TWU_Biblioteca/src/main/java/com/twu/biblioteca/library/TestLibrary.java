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
    public Optional<Book> getBookInfoByBookNo(String bookNo) {
        Optional<Book> checkBook = books.stream().filter(Book::isIn).filter(book -> bookNo.equals(book.getBookNo())).findFirst();
        checkBook.ifPresent(book -> book.setIn(false));

        return checkBook;
    }

    @Override
    public boolean returnBook(String bookNo) {
        Optional<Book> checkBook = books.stream().filter(book -> bookNo.equals(book.getBookNo())).findFirst();
        if(!checkBook.isPresent() || checkBook.get().isIn()) {
            return false;
        }
        checkBook.ifPresent(book -> book.setIn(true));
        return true;
    }
}
