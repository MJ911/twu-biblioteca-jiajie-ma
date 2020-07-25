package com.twu.biblioteca.libraryTest;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.TestLibrary;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TestLibraryTest {
    TestLibrary testLibrary;
    List<Book> books = Arrays.asList(
            new Book("1","Dimtree", 1992, true),
            new Book("2","Nick M", 2003,true),
            new Book("3","Mint", 2005,true));

    @Before
    public void setUp() {
        testLibrary = new TestLibrary(books);
    }

    @Test
    public void should_get_the_book_when_user_input_the_existing_book() {
        Optional<Book> exceptedBook = testLibrary.getBookInfoByBookNo("1");

        exceptedBook.ifPresent(book -> assertEquals(book.getBookNo(), "1"));
        exceptedBook.ifPresent(book -> assertEquals(book.getAuthor(), "Dimtree"));
        exceptedBook.ifPresent(book -> assertEquals(book.getPublishYear(), 1992));
        exceptedBook.ifPresent(book -> assertEquals(book.isIn(), false));
    }
}
