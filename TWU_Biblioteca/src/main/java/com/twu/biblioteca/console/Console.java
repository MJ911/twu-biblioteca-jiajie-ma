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
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s\n";
        printer.println("Listing all the books message in Biblioteca:");
        printer.printf(ENTRY_FORMAT, "-BookNo-","-AUTHOR-", "-PUBLISH YEAR-");
        libraryBooks.getAllBooks().forEach(book -> printer.printf(ENTRY_FORMAT, book.getBookNo(),book.getAuthor(), book.getPublishYear()));
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
            String optionNo = inputWithInfo("Please Choose the OptionNo and Input it:");
            if("Q".equals(optionNo)) {
                printer.println("Thanks your usage!");
                break;
            }
            if(Integer.parseInt(optionNo) == 1) {
                listBooks();
            }
            printer.println("Please select a valid option!");
        }
    }

    public String inputWithInfo(String info) {
        printer.println(info);
        return scanner.nextLine();
    }
}
