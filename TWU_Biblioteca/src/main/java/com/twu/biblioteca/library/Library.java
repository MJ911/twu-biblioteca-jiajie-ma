package com.twu.biblioteca.library;

import java.util.List;

public interface Library {
    List<Book> getAllBooks();

    Book getBookInfoByBookNo();
}
