package com.twu.biblioteca.console;

import com.twu.biblioteca.library.Library;

import java.io.PrintStream;

public class Console {
    private final PrintStream printer = System.out;
    private Library libraryBooks;

    public Console(Library libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public void start() {
        this.welcome();
        listBooks();
    }

    public void welcome() {
        printer.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listBooks() {
        final String ENTRY_FORMAT = "%-16s | %16s\n";
        printer.println("Listing all the books message in Biblioteca:");
        printer.printf(ENTRY_FORMAT, "-AUTHOR-", "-PUBLISH YEAR-");
        libraryBooks.getAllBooks().forEach(book -> System.out.printf(ENTRY_FORMAT, book.getAuthor(), book.getPublishYear()));
    }

}
