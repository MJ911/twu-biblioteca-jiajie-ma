package com.twu.biblioteca.console;

import com.twu.biblioteca.BibliotecaUtil;
import com.twu.biblioteca.library.Library;

import java.io.PrintStream;
import java.util.Scanner;

public class Console {
    private final PrintStream printer = System.out;
    private final Scanner scanner = new Scanner(System.in);
    private Library libraryBooks;
    private Menu bibliotecaMenu;

    public Console(Library libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public void start() {
        this.welcome();
        this.main();
    }

    public void welcome() {
        printer.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void listBooks() {
        final String ENTRY_FORMAT = "%-16s | %16s\n";
        printer.println("Listing all the books message in Biblioteca:");
        printer.printf(ENTRY_FORMAT, "-AUTHOR-", "-PUBLISH YEAR-");
        libraryBooks.getAllBooks().forEach(book -> printer.printf(ENTRY_FORMAT, book.getAuthor(), book.getPublishYear()));
    }

    public void main() {
        this.listOptios();
        this.runOption();
    }

    public void listOptios(){
        bibliotecaMenu = new Menu(BibliotecaUtil.getAllOptions());
        final String ENTRY_FORMAT = "%-16s | %16s\n";
        printer.println("Listing of Biblioteca menu:");
        printer.printf(ENTRY_FORMAT, "-OptionNo-", "-Description-");
        bibliotecaMenu.getMenuItems().forEach(option -> printer.printf(ENTRY_FORMAT, option.getOptionNo(), option.getDescription()));
    }

    public void runOption(){
        while(true) {
            printer.println("Please Choosing the OptionNo and Input it:");
            String optionNo = scanner.nextLine();
            if(Integer.parseInt(optionNo) == 1) {
                listBooks();
            } else {
                break;
            }
        }
    }
}
