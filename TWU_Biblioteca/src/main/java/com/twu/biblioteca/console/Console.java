package com.twu.biblioteca.console;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Library;

import java.io.PrintStream;
import java.util.List;

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
        StringBuilder bookStringBuilder = new StringBuilder("");
        List<Book> books = libraryBooks.getAllBooks();
        books.stream().map(s -> bookStringBuilder.append("Author: ").append(s.getAuthor()).append(" publishYear: ").append(s.getPublishYear()).append("\n")).count();
        printer.println(bookStringBuilder.toString());
    }

}
