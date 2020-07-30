package com.twu.biblioteca.libraryTest;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.TestLibraryBooks;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TestLibraryTest {
    TestLibraryBooks testLibrary;

    @Test
    public void should_get_the_book_when_user_input_the_existing_book() {
        List<Book> books = Arrays.asList(
                new Book("1","Dimtree", 1992, true),
                new Book("2","Nick M", 2003,true),
                new Book("3","Mint", 2005,true));

        testLibrary = new TestLibraryBooks(books);

        Optional<Book> exceptedBook = testLibrary.getBookInfoByItemNo("1");

        exceptedBook.ifPresent(book -> assertEquals("1" ,book.getItemNo()));
        exceptedBook.ifPresent(book -> assertEquals("Dimtree" ,book.getAuthor()));
        exceptedBook.ifPresent(book -> assertEquals(1992, book.getPublishYear()));
        exceptedBook.ifPresent(book -> assertEquals(false, book.isIn()));
    }

    @Test
    public void should_return_the_book_when_the_book_is_exist_and_is_not_in_library() {
        List<Book> books = Arrays.asList(
                new Book("1","Dimtree", 1992, false),
                new Book("2","Nick M", 2003,true),
                new Book("3","Mint", 2005,true));

        testLibrary = new TestLibraryBooks(books);

        boolean isReturn1 = testLibrary.returnItemByItemNo("1");
        boolean isReturn2 = testLibrary.returnItemByItemNo("2");
        boolean isReturn3 = testLibrary.returnItemByItemNo("4");

        assertTrue(isReturn1);
        assertFalse(isReturn2);
        assertFalse(isReturn3);
    }
}
