package com.twu.biblioteca.library;

import java.util.List;
import java.util.Optional;

public interface Library {
    List<Book> getAllBooks();

    Optional<Book> getBookInfoByBookNo();
}
